package com.hugidonic.data.remote

import com.hugidonic.data.remote.dto.NewsDto
import com.hugidonic.data.remote.dto.ScheduleDayDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/week_schedule/")
    suspend fun getWeekScheduleForGroup(
        @Query("group") groupNumber: String,
        @Query("type_of_week") typeOfWeek: String
    ): List<ScheduleDayDto>

    @GET("/news")
    suspend fun getNews(
        @Query("news_type") newsType: String
    ): List<NewsDto>
}