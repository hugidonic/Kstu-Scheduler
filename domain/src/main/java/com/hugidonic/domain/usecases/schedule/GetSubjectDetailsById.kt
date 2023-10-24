package com.hugidonic.domain.usecases.schedule

import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetSubjectDetailsById(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(subjectId: Int): Flow<Resource<SubjectModel>> {
        return scheduleRepository.getSubjectById(subjectId = subjectId)
    }
}