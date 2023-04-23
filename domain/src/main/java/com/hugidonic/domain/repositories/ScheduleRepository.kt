package com.hugidonic.domain.repositories

interface ScheduleRepository {
	suspend fun getSchedule()
	suspend fun getSubjectDetails()
	suspend fun saveSchedule()
}