package com.hugidonic.domain.usecases

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetScheduleDayInfoUseCase(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(dayOfWeek: String): Flow<Resource<ScheduleDayModel>> {
        return scheduleRepository.getScheduleDayInfo(dayOfWeek = dayOfWeek)
    }
}