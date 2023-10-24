package com.hugidonic.kstuscheduler.presentation.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.news.components.Filters
import com.hugidonic.kstuscheduler.presentation.news.components.NewsCard
import com.hugidonic.kstuscheduler.presentation.news.components.NewsList
import com.hugidonic.kstuscheduler.presentation.shared.LoadingCircle
import com.hugidonic.kstuscheduler.presentation.shared.pullToRefresh.PullRefreshIndicator
import com.hugidonic.kstuscheduler.presentation.shared.pullToRefresh.pullRefresh
import com.hugidonic.kstuscheduler.presentation.shared.pullToRefresh.rememberPullRefreshState

@Composable
fun NewsScreen(
    state: NewsState = NewsState(),
    actions: NewsActions = NewsActions()
) {
    val refreshing by remember {
        mutableStateOf(false)
    }
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = actions.onRefresh)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Filters(
            modifier = Modifier.padding(vertical = 18.dp),
            currentNewsType = state.currentNewsType,
            onNewsTypeClick = actions.onNewsTypeClick
        )
        
        if (state.newsList == null || state.isLoading) {
            LoadingCircle()
        } else {
            Box(modifier = Modifier
                .fillMaxSize()
                .pullRefresh(refreshState)) {
                NewsList(newsList = state.newsList, onNewsClick = actions.onNewsClick)
                PullRefreshIndicator(refreshing = refreshing, state = refreshState, modifier = Modifier.align(Alignment.TopCenter))
            }
        }
    }
}

@Composable
@Preview(name = "News")
private fun NewsScreenPreview() {
    NewsScreen()
}

