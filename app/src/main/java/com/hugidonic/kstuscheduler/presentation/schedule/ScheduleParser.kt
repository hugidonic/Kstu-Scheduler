package com.hugidonic.kstuscheduler.presentation.schedule

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object ScheduleParser {
    fun getSubjectState(date: String, startTime: String, endTime: String): SubjectState {
        val startTimeDate = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"))
        val endTimeDate = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"))
        val currentTime = LocalTime.now()

        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val scheduleDate = LocalDate.parse(date, dateFormatter)
        val currentDate = LocalDate.now()

        return if (scheduleDate == currentDate && currentTime in startTimeDate.minusHours(1)..endTimeDate) {
            SubjectState.ACTIVE
        } else if (scheduleDate == currentDate && currentTime > endTimeDate) {
            SubjectState.DISABLED
        } else {
            SubjectState.DEFAULT
        }
    }
}