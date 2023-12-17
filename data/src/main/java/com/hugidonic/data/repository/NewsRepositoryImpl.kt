package com.hugidonic.data.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hugidonic.data.converters.toEntity
import com.hugidonic.data.converters.toModel
import com.hugidonic.data.database.entities.dao.NewsDao
import com.hugidonic.data.remote.ApiService
import com.hugidonic.data.remote.dto.ErrorResponseDto
import com.hugidonic.data.remote.dto.NewsDto
import com.hugidonic.domain.models.NewsModel
import com.hugidonic.domain.repositories.NewsRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val newsDao: NewsDao
) : NewsRepository {

    override suspend fun getNews(isFetchFromRemote: Boolean, newsType: String): Flow<Resource<List<NewsModel>>> = flow {
        emit(Resource.Loading(true))
        val localNews = newsDao.getAllNewsByType(newsType).map {
            it.toModel()
        }

        val shouldLoadFromCache = localNews.isNotEmpty() && !isFetchFromRemote

        if (shouldLoadFromCache) {
            emit(Resource.Success(data = localNews))
            emit(Resource.Loading(false))
            return@flow
        }

        try {
            val remoteNews = apiService.getNews(newsType)
            saveNewsToDB(newsType = newsType, newsDTO = remoteNews)
        } catch (e: HttpException) {
            //            Getting the message from error.
            val type = object : TypeToken<ErrorResponseDto>() {}.type
            val errorMessage = Gson().fromJson<ErrorResponseDto>(
                e.response()?.errorBody()?.charStream(), type
            )
            emit(
                Resource.Error(
                    data = localNews,
                    message = errorMessage.detail.message
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    data = localNews,
                    message = "Что-то пошло не так. Попробуйте перезагрузить приложение."
                )
            )
        } finally {
            emit(Resource.Loading(false))
        }

        val newlocalNews = newsDao.getAllNewsByType(newsType).map {
            it.toModel()
        }

        emit(Resource.Success(data = newlocalNews))
        emit(Resource.Loading(false))
    }

    private suspend fun saveNewsToDB(newsType: String, newsDTO: List<NewsDto>) {
//        newsDao.deleteNewsByType(newsType)
        newsDTO.forEach {
            newsDao.insertNews(it.toEntity(newsType = newsType))
        }
    }


    override suspend fun getNewsById(newsId: Int): Flow<Resource<NewsModel>> = flow {
        emit(Resource.Loading(true))
        try {
            val newsEntity = newsDao.getNewsById(newsId)
            emit(Resource.Success(data = newsEntity.toModel()))
        } catch (e: IOException) {
            emit(Resource.Error(data = null, message = e.message?: "Что-то пошло не так..."))
        } finally {
            emit(Resource.Loading(false))
        }
    }
}