package com.hugidonic.data.remote

import com.google.common.truth.Truth
import com.hugidonic.data.remote.dto.SubjectDto
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RemoteTest {
    private lateinit var api: ApiService

    @BeforeEach
    fun before() {
        api = ApiFactory().scheduleApi
    }

    @AfterEach
    fun aftereach() {
        println('\n')
    }

    @Test
    @DisplayName("All subjects should come as SubjectDto List")
    fun remoteSubjects() = runTest {
        val subjectsListDto: List<SubjectDto?> = api.getSubjects()
        println(subjectsListDto.toString())
        Truth.assertThat(subjectsListDto).isNotEmpty()
    }

    @Test
    @DisplayName("Should contain schedule day info and subjects for this day")
    fun remoteFullSchedule() = runTest {
        val scheduleDayDto = api.getFullSchedule()
        println(scheduleDayDto.toString())
        Truth.assertThat(scheduleDayDto.dayOfWeek).isNotNull()
        Truth.assertThat(scheduleDayDto.date).isNotNull()
        Truth.assertThat(scheduleDayDto.typeOfWeek).isNotNull()
        Truth.assertThat(scheduleDayDto.subjects).isNotEmpty()
    }

    @Test
    @DisplayName("Should contain schedule day info")
    fun remoteScheduleDayInfo() = runTest {
        val scheduleDayDto = api.getScheduleDayInfo()
        println(scheduleDayDto.toString())
        Truth.assertThat(scheduleDayDto.dayOfWeek).isNotNull()
        Truth.assertThat(scheduleDayDto.date).isNotNull()
        Truth.assertThat(scheduleDayDto.typeOfWeek).isNotNull()
    }
}