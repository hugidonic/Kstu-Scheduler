package com.hugidonic.kstuscheduler.presentation.subjectdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SubjectDetailsRoute(
) {
    val coordinator: SubjectDetailsCoordinator = rememberSubjectDetailsCoordinator()
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(SubjectDetailsState())

    // UI Actions
    val actions = rememberSubjectDetailsActions(coordinator = coordinator)

    // UI Rendering
    SubjectDetailsScreen(uiState, actions)
}


@Composable
fun rememberSubjectDetailsActions(
    coordinator: SubjectDetailsCoordinator,
): SubjectDetailsActions {
    return remember(coordinator) {
        SubjectDetailsActions(
            onMakeRouteClick = coordinator::onMakeRouteClick,
        )
    }
}