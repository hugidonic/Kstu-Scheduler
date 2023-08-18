package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class ScheduleCoordinator(
    val viewModel: ScheduleViewModel
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberScheduleCoordinator(
    viewModel: ScheduleViewModel = hiltViewModel()
): ScheduleCoordinator {
    return remember(viewModel) {
        ScheduleCoordinator(
            viewModel = viewModel
        )
    }
}