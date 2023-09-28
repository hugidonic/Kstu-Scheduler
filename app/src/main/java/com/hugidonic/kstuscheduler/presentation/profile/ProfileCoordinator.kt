package com.hugidonic.kstuscheduler.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class ProfileCoordinator(
    val viewModel: ProfileViewModel
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberProfileCoordinator(
    viewModel: ProfileViewModel = hiltViewModel()
): ProfileCoordinator {
    return remember(viewModel) {
        ProfileCoordinator(
            viewModel = viewModel
        )
    }
}