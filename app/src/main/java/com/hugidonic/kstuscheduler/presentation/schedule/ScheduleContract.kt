package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hugidonic.domain.models.ClassModel
import com.hugidonic.domain.models.ScheduleDayModel


/**
 * UI State that represents ScheduleScreen
 **/
data class ScheduleState(
    val todayDayOfWeek: String? = null,
    val scheduleDay: ScheduleDayModel? = null,
    val classes: List<ClassModel>? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
)

sealed class UIEvent {
    class ShowSnackBar(val message: String): UIEvent()
}

/**
 * Schedule Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ScheduleActions(
    val onClick: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalScheduleActions = staticCompositionLocalOf<ScheduleActions> {
    error("{NAME} Actions Were not provided, make sure ProvideScheduleActions is called")
}

@Composable
fun ProvideScheduleActions(actions: ScheduleActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalScheduleActions provides actions) {
        content.invoke()
    }
}

