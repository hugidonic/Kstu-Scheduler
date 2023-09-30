package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun ScheduleRoute(
    navController: NavController,
) {
    val coordinator: ScheduleCoordinator = rememberScheduleCoordinator(navController = navController)

    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(ScheduleState())

    // UI Actions
    val uiActions = rememberScheduleActions(coordinator, navController)

    // UI Rendering
    ProvideScheduleActions(actions = uiActions) {
        ScheduleScreen(uiState, uiActions)
    }
}


@Composable
fun rememberScheduleActions(coordinator: ScheduleCoordinator, navController: NavController): ScheduleActions {
    return remember(coordinator, navController) {
        ScheduleActions(
            onDayOfWeekClick = coordinator::onDayOfWeekClick,
            onSubjectClick = coordinator::onSubjectClick,
            onChangeTypeOfWeek = coordinator::onChangeTypeOfWeek,
            onEditGroup = coordinator::onEditGroupClick
        )
    }
}