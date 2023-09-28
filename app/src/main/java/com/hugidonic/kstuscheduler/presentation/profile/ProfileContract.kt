package com.hugidonic.kstuscheduler.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents ProfileScreen
 **/
class ProfileState

/**
 * Profile Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ProfileActions(
    val onClick: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalProfileActions = staticCompositionLocalOf<ProfileActions> {
    error("{NAME} Actions Were not provided, make sure ProvideProfileActions is called")
}

@Composable
fun ProvideProfileActions(actions: ProfileActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalProfileActions provides actions) {
        content.invoke()
    }
}

