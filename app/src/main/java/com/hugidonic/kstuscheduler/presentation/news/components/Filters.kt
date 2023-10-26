package com.hugidonic.kstuscheduler.presentation.news.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

@Composable
fun Filters(
    modifier: Modifier = Modifier,
    currentNewsType: String,
    onNewsTypeClick: (String) -> Unit
) {
    val filters = listOf("Официальная хроника", "Университетская жизнь", "Гранты, конкурсы, объявления")

    LazyRow(modifier = modifier) {
        item { Spacer(modifier = Modifier.width(10.dp)) }
        items(filters) {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 6.dp,
                        shape = RoundedCornerShape(50)
                    )
                    .clickable {
                        onNewsTypeClick(it)
                    }
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
private fun PreviewFilters() {
    AppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            Filters(
                modifier = Modifier.padding(20.dp),
                currentNewsType = "Официальная хроника",
                onNewsTypeClick = {},
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewFilters_dark() {
    PreviewFilters()
}

@Preview()
@Composable
fun PreviewFilters_light() {
    PreviewFilters()
}