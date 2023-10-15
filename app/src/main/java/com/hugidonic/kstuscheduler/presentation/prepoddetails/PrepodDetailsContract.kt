package com.hugidonic.kstuscheduler.presentation.prepoddetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hugidonic.domain.models.PrepodDetailsModel


/**
 * UI State that represents PrepodDetailsScreen
 **/
data class PrepodDetailsState(
    val prepodDetails: PrepodDetailsModel? = null
)

/**
 * PrepodDetails Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class PrepodDetailsActions(
    val onClick: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalPrepodDetailsActions = staticCompositionLocalOf<PrepodDetailsActions> {
    error("{NAME} Actions Were not provided, make sure ProvidePrepodDetailsActions is called")
}

@Composable
fun ProvidePrepodDetailsActions(actions: PrepodDetailsActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalPrepodDetailsActions provides actions) {
        content.invoke()
    }
}

