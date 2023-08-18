package com.hugidonic.domain.usecases

import com.hugidonic.domain.models.ClassModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetClassesUseCase(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(dayOfWeek: String): Flow<Resource<List<ClassModel>>> {
        return scheduleRepository.getClasses(dayOfWeek = dayOfWeek)
    }
}