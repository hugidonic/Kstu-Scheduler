package com.hugidonic.data.db.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.hugidonic.data.database.AppDatabase
import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.data.remote.ApiFactory
import com.hugidonic.data.repository.ScheduleRepositoryImpl
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScheduleRepositoryTest {
    private lateinit var repository: ScheduleRepository
    private lateinit var db: AppDatabase
    private lateinit var dao: ScheduleDao

    @BeforeEach
    fun beforeEach() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        dao = db.scheduleDao()

        repository = ScheduleRepositoryImpl(
            apiService = ApiFactory().scheduleApi,
            scheduleDao = dao
        )
    }

    @Test
    @DisplayName("Should get scheduleInfo")
    fun getScheduleDayInfoTest() = runTest {
        repository.getScheduleDayInfo(
            isFetchFromRemote = true,
            dayOfWeek = "Пн"
        ).collect { result ->
            when (result) {
                is Resource.Success -> {
                    Truth.assertThat(result.data).isNotNull()
                    println(result.data)
                }

                is Resource.Error -> {
                    throw Exception(result.message)
                }

                is Resource.Loading -> {
                    if (!result.isLoading) {
                        Truth.assertThat(result.data).isNotNull()
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Should fetch classes from api and save them to DB")
    fun shouldGetRemoteSubjects() = runTest {
        repository
            .getClasses(dayOfWeek = "Пн", isFetchFromRemote = true)
            .collect { result ->
                when (result) {
                    is Resource.Success -> {
                        Truth.assertThat(result.data).isNotNull()
                        println(result.data)
                    }

                    is Resource.Error -> {
                        throw Exception(result.message)
                    }

                    is Resource.Loading -> {
                        if (!result.isLoading) {
                            Truth.assertThat(result.data).isNotNull()
                        }
                    }
                }
            }

        val subjectsFromDb = dao.getAllSubjects()
        Truth.assertThat(subjectsFromDb).isNotEmpty()

        val classes = dao.getSubjectsAndClasses(dayOfWeek = "Пн")
        println(classes)
        Truth.assertThat(classes).isNotEmpty()

    }
}