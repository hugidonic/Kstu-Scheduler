package com.hugidonic.data.remote

import com.hugidonic.data.remote.dto.ScheduleDayDto
import com.hugidonic.data.remote.dto.SubjectDto
import retrofit2.http.GET

interface ApiService {

    @GET("/full_schedule")
    suspend fun getFullSchedule(): ScheduleDayDto

    @GET("/schedule_info")
    suspend fun getScheduleDayInfo(): ScheduleDayDto

    @GET("/subjects")
    suspend fun getSubjects(): List<SubjectDto?>
}