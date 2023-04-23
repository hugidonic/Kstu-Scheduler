package com.hugidonic.domain.usecases

import com.hugidonic.domain.repositories.ScheduleRepository

class SaveScheduleUseCase(private val scheduleRepository: ScheduleRepository) {
	suspend operator fun invoke() {
		scheduleRepository.saveSchedule()
	}
}