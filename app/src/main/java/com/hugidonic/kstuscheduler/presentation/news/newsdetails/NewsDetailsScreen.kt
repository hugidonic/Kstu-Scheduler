package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsDetailsScreen(
    state: NewsDetailsState = NewsDetailsState(),
    actions: NewsDetailsActions = NewsDetailsActions()
) {
    Column {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxWidth()
                .height(300.dp)
        )
        Column() {

        }

    }
}

@Composable
@Preview(name = "NewsDetails")
private fun NewsDetailsScreenPreview() {
    NewsDetailsScreen()
}

