package com.hugidonic.data.db.scheduleDao

import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.hugidonic.data.converters.toSubjectEntity
import com.hugidonic.data.database.AppDatabase
import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.data.database.entities.ClassEntity
import com.hugidonic.data.database.entities.SubjectEntity
import com.hugidonic.data.db.scheduleDao.dummyData.DummyData
import com.hugidonic.domain.models.SubjectModel
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SubjectTests {
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
    @DisplayName("Should insert and query class and subject")
    fun shouldInsertAndQueryClassAndSubject() = runTest {
        val subjectEntity = SubjectEntity(
            subjectTitle="Основы информационной безопасности",
            shortTitle="ОИБ",
            typeOfSubject="Лекция",
            prepod="Садыков А.М.",
            cabinet="И-1-209",
            date="1 сен - 1 янв"
        )
        dao.insertSubject(subjectEntity)
        val subjectFromDb = dao.searchSubject("ОИБ")
        Truth.assertThat(subjectFromDb).isNotNull()

        Log.d("test", "subjectFromDb: $subjectFromDb")

        val classEntity = ClassEntity(
            subjectTitle = subjectFromDb.subjectTitle,
            dayOfWeek = "Пн",
            orderIndex = 1,
        )
        dao.insertClass(classEntity)

        val classesFromDb = dao.getSubjectsAndClasses("Пн")
        Truth.assertThat(classesFromDb).isNotEmpty()
        Log.d("test", "classesFromDb: $classesFromDb")

        Truth.assertThat(classesFromDb).isNotEmpty()
    }

    @Test
    @DisplayName("Should search subject by query such as title and short title")
    fun shouldSearchSubjectByQuery() = runTest {
        subjects.forEach {
            it?.let {
                val subjectEntity = it.toSubjectEntity()
                dao.insertSubject(subjectEntity)
            }
        }

        val searchResultByShortTitle = dao.searchSubject("ОИБ")
        Truth.assertThat(searchResultByShortTitle).isNotNull()

        val searchResultBySubjectTitle = dao.searchSubject("Основы Ин")
        Truth.assertThat(searchResultBySubjectTitle).isNotNull()

        val emptySearchResult = dao.searchSubject("ASDASDASDASD")
        Truth.assertThat(emptySearchResult).isNull()
    }

    @Test
    @DisplayName("Should insert list of subjects")
    fun shouldInsertList() = runTest {
        subjects.map {
            it?.let {
                val subjectEntity = it.toSubjectEntity()
                dao.insertSubject(subjectEntity)
            }
        }

        val subjectsFromDb = dao.getAllSubjects()
        Truth.assertThat(subjectsFromDb).isNotEmpty()
        Log.d("test", subjectsFromDb.toString())
    }

}