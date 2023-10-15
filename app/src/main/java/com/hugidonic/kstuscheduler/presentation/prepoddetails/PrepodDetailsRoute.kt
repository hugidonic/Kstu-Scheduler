package com.hugidonic.kstuscheduler.presentation.prepoddetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PrepodDetailsRoute(
    coordinator: PrepodDetailsCoordinator = rememberPrepodDetailsCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(PrepodDetailsState())

    // UI Actions
    val actions = rememberPrepodDetailsActions(coordinator)

    // UI Rendering
    PrepodDetailsScreen(uiState, actions)
}


@Composable
fun rememberPrepodDetailsActions(coordinator: PrepodDetailsCoordinator): PrepodDetailsActions {
    return remember(coordinator) {
        PrepodDetailsActions(
        )
    }
}