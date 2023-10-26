package com.hugidonic.kstuscheduler.presentation.news

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun NewsRoute(
    navController: NavController,
    snackbarHostState: SnackbarHostState
) {
    val coordinator: NewsCoordinator = rememberNewsCoordinator(navController=navController, snackbarHostState = snackbarHostState)
    // State observing and declarations
    val uiState by coordinator.stateFlow.collectAsStateWithLifecycle(NewsState())

    // UI Actions
    val actions = rememberNewsActions(coordinator)

    // UI Rendering
    NewsScreen(uiState, actions)
}


@Composable
fun rememberNewsActions(coordinator: NewsCoordinator): NewsActions {
    return remember(coordinator) {
        NewsActions(
            onNewsClick = coordinator::handleNewsClick,
            onNewsTypeClick = coordinator::handleNewsTypeClick,
            onRefresh = coordinator::handleRefresh
        )
    }
}