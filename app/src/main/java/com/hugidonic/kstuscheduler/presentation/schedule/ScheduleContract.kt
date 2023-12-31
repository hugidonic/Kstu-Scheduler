package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hugidonic.domain.models.ScheduleDayModel


/**
 * UI State that represents ScheduleScreen
 **/
data class ScheduleState(
    val weekScheduleDays: List<ScheduleDayModel>? = null,
    val currentTypeOfWeek: String = "",
    val group: String = "1211-22",
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
)

/**
 * UI events
 **/
sealed class ScheduleUIEvent {
    class ShowSnackbar(val message: String): ScheduleUIEvent()
//    class Refresh(val isRefreshing: Boolean): ScheduleUIEvent()
}

/**
 * UI State that represents ScheduleScreen
 **/

enum class SubjectState {
    ACTIVE,
    DISABLED,
    DEFAULT,
}

/**
 * Schedule Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ScheduleActions(
    val onDayOfWeekClick: (dayOfWeekIdx: Int) -> Unit = {},
    val onSubjectClick: (subjectId: Int) -> Unit = {},
    val onChangeTypeOfWeek: () -> Unit = {},
    val onEditGroup: (newGroup: String) -> Unit = {},
    val onRefresh: () -> Unit = {}
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

