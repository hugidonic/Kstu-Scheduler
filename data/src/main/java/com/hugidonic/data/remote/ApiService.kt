package com.hugidonic.data.remote

import com.hugidonic.data.remote.dto.ScheduleDayDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/week_schedule/")
    suspend fun getWeekScheduleForGroup(
        @Query("group") groupNumber: String,
        @Query("type_of_week") typeOfWeek: String
    ): List<ScheduleDayDto>

    @GET("/week_schedule/chet")
    suspend fun getChetWeekSchedule(): List<ScheduleDayDto>
}