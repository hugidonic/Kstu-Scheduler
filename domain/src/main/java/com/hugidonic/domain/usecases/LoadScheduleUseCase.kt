package com.hugidonic.domain.usecases

import com.hugidonic.domain.repositories.ScheduleRepository

class LoadScheduleUseCase(private val scheduleRepository: ScheduleRepository) {
	suspend operator fun invoke() {
		scheduleRepository.loadSchedule()
	}
}