package com.hugidonic.domain.repositories

import com.hugidonic.domain.models.ScheduleDayModel

interface ScheduleRepository {
	suspend fun loadSchedule(): ScheduleDayModel

	suspend fun getSchedule()
	suspend fun getSubjectDetails()
	suspend fun saveSchedule()
}