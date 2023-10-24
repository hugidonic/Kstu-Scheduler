package com.hugidonic.domain.usecases.utils

import com.hugidonic.domain.repositories.ScheduleRepository

class GetTypeOfWeekUseCase(private val scheduleRepository: ScheduleRepository) {
    operator fun invoke(): String {
        return scheduleRepository.getTypeOfWeek()
    }
}