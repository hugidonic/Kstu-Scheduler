package com.hugidonic.domain.usecases.utils

import com.hugidonic.domain.repositories.ScheduleRepository
import java.time.LocalDate

class GetCurrentDateUseCase(private val scheduleRepository: ScheduleRepository) {
    operator fun invoke(): LocalDate {
        return scheduleRepository.getCurrentDate()
    }
}