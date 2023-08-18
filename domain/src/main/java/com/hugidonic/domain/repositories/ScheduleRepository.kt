package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.ClassModel
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {

    suspend fun getScheduleDayInfo(
        dayOfWeek: String,
    ): Flow<Resource<ScheduleDayModel>>

    suspend fun getClasses(dayOfWeek: String): Flow<Resource<List<ClassModel>>>

    suspend fun getSubjectDetails(subjectTitle: String): SubjectModel
}