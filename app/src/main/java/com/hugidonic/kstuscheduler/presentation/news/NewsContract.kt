package com.hugidonic.kstuscheduler.presentation.news

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hugidonic.domain.models.NewsModel


/**
 * UI State that represents NewsScreen
 **/
data class NewsState(
    val currentNewsType: String = "",
    val newsList: List<NewsModel>? = null,
    val isLoading: Boolean = false,
)

/**
 * News Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class NewsActions(
    val onNewsClick: (newsId: Int) -> Unit = {},
    val onRefresh: () -> Unit = {},
    val onNewsTypeClick: (newsType: String) -> Unit = {},
)

/**
 * UI events
 **/
sealed class NewsUiEvent {
    class ShowSnackbar(val message: String): NewsUiEvent()
}

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalNewsActions = staticCompositionLocalOf<NewsActions> {
    error("{NAME} Actions Were not provided, make sure ProvideNewsActions is called")
}

@Composable
fun ProvideNewsActions(actions: NewsActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalNewsActions provides actions) {
        content.invoke()
    }
}

