package com.hugidonic.domain.usecases.news

import com.hugidonic.domain.models.NewsModel
import com.hugidonic.domain.repositories.NewsRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(isFetchFromRemote: Boolean = false, newsType: String): Flow<Resource<List<NewsModel>>> {
        return newsRepository.getNews(isFetchFromRemote = isFetchFromRemote, newsType = newsType)
    }
}