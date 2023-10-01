package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ScheduleRepository {
    suspend fun getWeekSchedule(
        isFetchFromApi: Boolean,
        typeOfWeek: String = getTypeOfWeek()
    ): Flow<Resource<List<ScheduleDayModel>>>

    suspend fun getScheduleDayFromDB(
        typeOfWeek: String,
        dayOfWeek: String,
    ): ScheduleDayModel?

    suspend fun getSubjectById(subjectId: Int): Flow<Resource<SubjectModel>>

    fun getTypeOfWeek(): String
    fun getCurrentDate(): LocalDate
}