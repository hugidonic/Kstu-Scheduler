package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ScheduleRoute(
    coordinator: ScheduleCoordinator = rememberScheduleCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(ScheduleState())

    // UI Actions
    val uiActions = rememberScheduleActions(coordinator)

    // UI Rendering
    ProvideScheduleActions(actions = uiActions) {
        ScheduleScreen(uiState, uiActions)
    }
}


@Composable
fun rememberScheduleActions(coordinator: ScheduleCoordinator): ScheduleActions {
    return remember(coordinator) {
        ScheduleActions(
            onDayOfWeekClick = coordinator::onDayOfWeekClick,
            onSubjectClick = coordinator::onSubjectClick,
            onChangeTypeOfWeek = coordinator::onChangeTypeOfWeek
        )
    }
}