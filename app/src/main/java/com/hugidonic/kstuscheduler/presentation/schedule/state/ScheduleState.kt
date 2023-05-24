package com.hugidonic.kstuscheduler.presentation.schedule.state

import com.hugidonic.domain.models.ScheduleDayModel

data class ScheduleState(
    val scheduleDay: ScheduleDayModel? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
)