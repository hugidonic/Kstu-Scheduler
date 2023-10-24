package com.hugidonic.data.database.entities.dao

import androidx.room.*
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.database.entities.relations.ScheduleDayWithSubjects

@Dao
interface ScheduleDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScheduleDay(scheduleDayEntity: ScheduleDayEntity)

    @Transaction
    suspend fun insertWeekSchedule(entities: List<ScheduleDayEntity>) {
        entities.forEach { insertScheduleDay(it) }
    }

    @Transaction
    @Query("SELECT * FROM schedule_day WHERE typeOfWeek == :typeOfWeek LIMIT 6")
    suspend fun getWeekScheduleByType(typeOfWeek: String): List<ScheduleDayWithSubjects>

    @Transaction
    @Query("SELECT * FROM schedule_day WHERE scheduleDayId == :scheduleDayId LIMIT 1")
    suspend fun getScheduleDay(scheduleDayId: String): ScheduleDayWithSubjects?

    @Query("DELETE FROM schedule_day WHERE typeOfWeek = :typeOfWeek")
    suspend fun clearScheduleDayTable(typeOfWeek: String)
}