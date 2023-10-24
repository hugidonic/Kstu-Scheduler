package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class NewsDetailsCoordinator(
    val viewModel: NewsDetailsViewModel
) {
    val screenStateFlow = viewModel.stateFlow
}

@Composable
fun rememberNewsDetailsCoordinator(
    viewModel: NewsDetailsViewModel = hiltViewModel()
): NewsDetailsCoordinator {
    return remember(viewModel) {
        NewsDetailsCoordinator(
            viewModel = viewModel
        )
    }
}