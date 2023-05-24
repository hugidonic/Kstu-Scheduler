package com.hugidonic.domain.usecases

import com.hugidonic.domain.repositories.ScheduleRepository

class GetScheduleUseCase(private val scheduleRepository: ScheduleRepository) {
    suspend operator fun invoke(isFetchFromRemote: Boolean) {
        scheduleRepository.getSchedule(isFetchFromRemote = isFetchFromRemote)
    }
}