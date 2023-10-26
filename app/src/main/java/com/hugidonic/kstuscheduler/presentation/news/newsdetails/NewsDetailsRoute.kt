package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NewsDetailsRoute(
    coordinator: NewsDetailsCoordinator = rememberNewsDetailsCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(NewsDetailsState())

    // UI Actions
    val actions = rememberNewsDetailsActions(coordinator)

    // UI Rendering
    NewsDetailsScreen(uiState, actions)
}


@Composable
fun rememberNewsDetailsActions(coordinator: NewsDetailsCoordinator): NewsDetailsActions {
    return remember(coordinator) {
        NewsDetailsActions()
    }
}