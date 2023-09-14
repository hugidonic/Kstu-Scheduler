package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

interface ScheduleRepository {
    suspend fun getWeekSchedule(
        isFetchFromApi: Boolean,
        typeOfWeek: String = getTypeOfWeek()
    ): Flow<Resource<List<ScheduleDayModel>>>

    suspend fun getScheduleDayFromDB(
        typeOfWeek: String,
        dayOfWeek: String,
    ): ScheduleDayModel?

    fun getTypeOfWeek(): String
    fun getCurrentDate(): LocalDate
}