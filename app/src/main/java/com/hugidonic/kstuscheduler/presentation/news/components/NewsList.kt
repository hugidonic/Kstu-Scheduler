package com.hugidonic.kstuscheduler.presentation.news.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.models.NewsModel

@Composable
fun NewsList(
    modifier: Modifier = Modifier,
    newsList: List<NewsModel>,
    onNewsClick: (Int) -> Unit
) {
    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        items(newsList) {
            NewsCard(newsInfo = it, onNewsClick = onNewsClick)
            Spacer(modifier = Modifier.height(22.dp))
        }
    }
}
