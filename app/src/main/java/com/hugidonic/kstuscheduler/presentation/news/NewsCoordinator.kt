package com.hugidonic.kstuscheduler.presentation.news

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class NewsCoordinator(
    val viewModel: NewsViewModel,
    scope: CoroutineScope,
    val snackbarHostState: SnackbarHostState,
    val navController: NavController,
) {
    val stateFlow = viewModel.stateFlow

    init {
        scope.launch {
            viewModel.eventFlow.collectLatest {
                when (it) {
                    is NewsUiEvent.ShowSnackbar -> {
                        snackbarHostState.showSnackbar(message = it.message)
                    }
                }
            }
        }
    }

    fun handleRefresh() {
        viewModel.onRefresh()
    }

    fun handleNewsTypeClick(newsType: String) {
        viewModel.changeCurrentNewsType(newsType)
    }

    fun handleNewsClick(newsId: Int) {
        navController.navigate(Screen.NewsDetails.createRoute(newsId = newsId))
    }
}

@Composable
fun rememberNewsCoordinator(
    viewModel: NewsViewModel = hiltViewModel(),
    navController: NavController,
    snackbarHostState: SnackbarHostState,
): NewsCoordinator {

    val scope = rememberCoroutineScope()

    return remember(viewModel) {
        NewsCoordinator(
            viewModel = viewModel,
            scope = scope,
            snackbarHostState = snackbarHostState,
            navController = navController
        )
    }
}