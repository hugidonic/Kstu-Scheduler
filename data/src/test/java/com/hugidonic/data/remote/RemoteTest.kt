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
    fun beforeEach() {
        api = ApiFactory().scheduleApi
    }

    @Test
    fun `Should get week schedule for chet week`() = runTest {
        val weekSchedule = api.getChetWeekSchedule()

        Truth.assertThat(weekSchedule).isNotEmpty()
        weekSchedule.forEach {
            Truth.assertThat(it.typeOfWeek).isNotEmpty()
            Truth.assertThat(it.dayOfWeek).isNotEmpty()
            Truth.assertThat(it.date).isNotEmpty()
            Truth.assertThat(it.subjects).isNotNull()
        }
    }
}