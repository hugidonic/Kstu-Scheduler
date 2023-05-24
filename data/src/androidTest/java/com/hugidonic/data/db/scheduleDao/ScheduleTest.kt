package com.hugidonic.data.db.scheduleDao

import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.hugidonic.data.converters.toSubjectEntity
import com.hugidonic.data.database.AppDatabase
import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.data.database.entities.ClassEntity
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.db.scheduleDao.dummyData.DummyData
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.utils.DayOfWeek
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScheduleTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: ScheduleDao
    private lateinit var subjects: List<SubjectModel?>

    @BeforeEach
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        dao = db.scheduleDao()
        subjects = DummyData.subjects
    }

    @Test
    @DisplayName("Should insert schedule and get day info")
    fun should_insert_schedule_day_info()= runTest {
        val scheduleDayEntity = ScheduleDayEntity(
            dayOfWeek = DayOfWeek.Mon,
            typeOfWeek = "нечет",
            date = "12.12.2023"
        )
        dao.insertScheduleDay(scheduleDayEntity)

        val dbEntityList = dao.getScheduleDay(DayOfWeek.Mon)
        Truth.assertThat(dbEntityList).isEqualTo(scheduleDayEntity)
    }

    @Test
    @DisplayName("Should get schedule day and classes")
    fun shouldInsertListOfSubjectsScheduleDay() = runTest {

        val scheduleDayEntity = ScheduleDayEntity(
            dayOfWeek = DayOfWeek.Mon,
            typeOfWeek = "нечет",
            date = "12.12.2023"
        )
        dao.insertScheduleDay(scheduleDayEntity)
        val scheduleFromDb = dao.getScheduleDay(DayOfWeek.Mon)
        Truth.assertThat(scheduleFromDb).isNotNull()

        subjects.forEachIndexed { idx, subject ->
            subject?.let {
                val subjectEntity = subject.toSubjectEntity()
                dao.insertSubject(subjectEntity)
                val classEntity = ClassEntity(
                    subjectTitle = subjectEntity.subjectTitle,
                    dayOfWeek = scheduleDayEntity.dayOfWeek,
                    orderIndex = idx
                )
                dao.insertClass(classEntity)
            }
        }

        val subjectsFromDb = dao.getAllSubjects()
        Truth.assertThat(subjectsFromDb).isNotNull()

        val dbClasses = dao.getSubjectsAndClasses(dayOfWeek = DayOfWeek.Mon)

        Truth.assertThat(dbClasses).isNotEmpty()
        Log.d("test", "dbClasses indexes: ${dbClasses.map {it.classEntity.orderIndex}}")
    }

}