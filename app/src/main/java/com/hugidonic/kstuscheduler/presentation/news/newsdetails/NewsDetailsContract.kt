package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hugidonic.domain.models.NewsModel


/**
 * UI State that represents NewsDetailsScreen
 **/
data class NewsDetailsState (
    val newsDetails: NewsModel? = null,
    val isLoading: Boolean = false,
)

/**
 * NewsDetails Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
class NewsDetailsActions

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalNewsDetailsActions = staticCompositionLocalOf<NewsDetailsActions> {
    error("{NAME} Actions Were not provided, make sure ProvideNewsDetailsActions is called")
}

@Composable
fun ProvideNewsDetailsActions(actions: NewsDetailsActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalNewsDetailsActions provides actions) {
        content.invoke()
    }
}

