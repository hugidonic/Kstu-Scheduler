package com.hugidonic.data.remote

import com.hugidonic.data.remote.dto.ScheduleDayDto
import retrofit2.http.GET

interface ApiService {

    @GET("/week_schedule/chet")
    suspend fun getChetWeekSchedule(): List<ScheduleDayDto>

    @GET("/week_schedule/nechet")
    suspend fun getNechetWeekSchedule(): List<ScheduleDayDto>

}