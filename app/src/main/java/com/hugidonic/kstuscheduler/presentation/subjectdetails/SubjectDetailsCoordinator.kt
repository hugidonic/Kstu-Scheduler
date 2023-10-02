package com.hugidonic.kstuscheduler.presentation.subjectdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class SubjectDetailsCoordinator(
    val viewModel: SubjectDetailsViewModel,
) {
    val screenStateFlow = viewModel.stateFlow

    fun onMakeRouteClick() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberSubjectDetailsCoordinator(
    viewModel: SubjectDetailsViewModel = hiltViewModel(),
): SubjectDetailsCoordinator {
    return remember(viewModel) {
        SubjectDetailsCoordinator(
            viewModel = viewModel,
        )
    }
}