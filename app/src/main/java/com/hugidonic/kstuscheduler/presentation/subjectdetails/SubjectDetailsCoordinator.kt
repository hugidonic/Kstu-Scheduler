package com.hugidonic.kstuscheduler.presentation.subjectdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hugidonic.kstuscheduler.presentation.navigation.Screen

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class SubjectDetailsCoordinator(
    val viewModel: SubjectDetailsViewModel,
    val navController: NavController
) {
    val screenStateFlow = viewModel.stateFlow

    fun onPrepodClick(prepodId: Int) {
        navController.navigate(Screen.PrepodDetails.createRoute(prepodId = prepodId))
    }
}

@Composable
fun rememberSubjectDetailsCoordinator(
    viewModel: SubjectDetailsViewModel = hiltViewModel(),
    navController: NavController
): SubjectDetailsCoordinator {
    return remember(viewModel) {
        SubjectDetailsCoordinator(
            viewModel = viewModel,
            navController = navController
        )
    }
}