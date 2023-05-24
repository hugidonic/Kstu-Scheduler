package com.hugidonic.data.database

import androidx.room.*
import com.hugidonic.data.database.entities.ClassEntity
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.database.entities.SubjectEntity
import com.hugidonic.data.database.entities.relations.SubjectAndClass
import com.hugidonic.domain.utils.DayOfWeek

@Dao
interface ScheduleDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertScheduleDay(scheduleDayEntity: ScheduleDayEntity)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertSubject(subjectEntity: SubjectEntity)

	@Query("SELECT * FROM subject")
	suspend fun getAllSubjects(): List<SubjectEntity>

	@Query("SELECT * FROM schedule_day WHERE dayOfWeek == :dayOfWeek LIMIT 1")
	suspend fun getScheduleDay(dayOfWeek: DayOfWeek): ScheduleDayEntity

	@Query("""
		SELECT * FROM subject 
		WHERE LOWER(subjectTitle) LIKE '%' || LOWER(:query) || '%' OR UPPER(:query) == shortTitle
	""")
	suspend fun searchSubject(query: String): List<SubjectEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertClass(classEntity: ClassEntity)

	@Transaction
	@Query("SELECT * FROM class_subject WHERE dayOfWeek == :dayOfWeek")
	suspend fun getSubjectsAndClasses(dayOfWeek: DayOfWeek): List<SubjectAndClass>

}