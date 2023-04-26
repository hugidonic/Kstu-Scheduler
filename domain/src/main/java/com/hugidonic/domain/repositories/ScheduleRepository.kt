package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.ScheduleDayModel

interface ScheduleRepository {
	suspend fun loadSchedule()

	suspend fun getSchedule(): ScheduleDayModel
	suspend fun getSubjectDetails()
	suspend fun saveSchedule(scheduleDayModel: ScheduleDayModel)
}