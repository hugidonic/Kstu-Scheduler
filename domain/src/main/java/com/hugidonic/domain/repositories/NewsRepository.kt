package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.NewsModel
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(isFetchFromRemote: Boolean, newsType: String): Flow<Resource<List<NewsModel>>>
}