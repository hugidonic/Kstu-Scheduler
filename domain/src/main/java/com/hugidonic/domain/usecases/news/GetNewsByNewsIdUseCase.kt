package com.hugidonic.domain.usecases.news

import com.hugidonic.domain.models.NewsModel
import com.hugidonic.domain.repositories.NewsRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetNewsByNewsIdUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(newsId: Int): Flow<Resource<NewsModel>> {
        return newsRepository.getNewsById(newsId = newsId)
    }
}