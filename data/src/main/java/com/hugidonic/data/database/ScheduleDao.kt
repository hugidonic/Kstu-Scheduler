package com.hugidonic.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ScheduleDao {

	@Query("SELECT * FROM schedule_day WHERE dayOfWeek == :dayOfWeek")
	fun getSchedule(dayOfWeek: String): ScheduleDayDbModel

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertSchedule(scheduleDay: ScheduleDayDbModel)
}