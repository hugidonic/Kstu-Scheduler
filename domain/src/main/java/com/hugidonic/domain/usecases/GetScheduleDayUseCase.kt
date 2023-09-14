package com.hugidonic.domain.usecases

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.repositories.ScheduleRepository

class GetScheduleDayUseCase(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(typeOfWeek: String, dayOfWeek: String): ScheduleDayModel? {
        return scheduleRepository.getScheduleDayFromDB(typeOfWeek = typeOfWeek, dayOfWeek = dayOfWeek)
    }
}