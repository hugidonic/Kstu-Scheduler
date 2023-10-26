package com.hugidonic.data.db.scheduleDao.schedule

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.hugidonic.data.converters.toScheduleDayEntity
import com.hugidonic.data.database.AppDatabase
import com.hugidonic.data.database.entities.dao.ScheduleDao
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.remote.ApiFactory
import com.hugidonic.data.remote.ApiService
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.SubjectModel
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScheduleDayDaoTest {
    private lateinit var db: AppDatabase
    private lateinit var dao: ScheduleDao
    private lateinit var api: ApiService
    private lateinit var subjects: List<SubjectModel>

    @BeforeEach
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        dao = db.scheduleDao()
        api = ApiFactory().scheduleApi
    }

    @Test
    @DisplayName("Should save schedule day to db")
    fun should_save_schedule_day_to_db() = runTest {
        val scheduleDayId = "Чет/Пн"
        val scheduleDayEntity = ScheduleDayEntity(
            dayOfWeek = "Пн",
            typeOfWeek = "Чет",
            date = "12.02.2023",
            scheduleDayId = scheduleDayId
        )

        dao.insertScheduleDay(scheduleDayEntity)

        val scheduleDayFromDb = dao.getScheduleDay(scheduleDayId = scheduleDayId)

        Truth.assertThat(scheduleDayFromDb?.scheduleDayInfo).isEqualTo(scheduleDayEntity)
    }

    @Test
    @DisplayName("Should save list of schedule days to db")
    fun should_save_list_of_schedule_days_to_db() = runTest {
        val weekScheduleEntities = DummyData.weekSchedule.map { it.toScheduleDayEntity() }
        dao.insertWeekSchedule(weekScheduleEntities)

        val typeOfWeek = weekScheduleEntities[0].typeOfWeek
        val weekFromDb = dao.getWeekScheduleByType(typeOfWeek = typeOfWeek)
        Truth.assertThat(weekFromDb).isNotEmpty()
        weekFromDb.forEach {
            Truth.assertThat(it.scheduleDayInfo).isNotNull()
            Truth.assertThat(it.subjects).isNotNull()
        }
    }
}