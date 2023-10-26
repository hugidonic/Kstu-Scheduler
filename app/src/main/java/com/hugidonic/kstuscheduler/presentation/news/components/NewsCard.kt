package com.hugidonic.kstuscheduler.presentation.news.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.hugidonic.domain.models.NewsModel
import com.hugidonic.kstuscheduler.presentation.shared.LoadingCircle
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    newsInfo: NewsModel,
    onNewsClick: (newsId: Int) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier
            .clickable {
                onNewsClick(newsInfo.newsId)
            }
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(newsInfo.imageUrl[0])
                    .crossfade(true)
                    .build(),

                loading = {
                    LoadingCircle(size = 50.dp, strokeWidth = 5.dp)
                },
                contentScale = ContentScale.Crop,
                contentDescription = "news image",
                modifier = Modifier
                    .width(120.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.padding(top = 8.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = newsInfo.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = newsInfo.title,
                    color = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun PreviewNewsCard() {
    AppTheme {
        Surface {
            NewsCard(
                modifier = Modifier.padding(15.dp),
                newsInfo = NewsModel(
                    title = "Кафедра физической и коллоидной химии КНИТУ приняла стажеров из Калининграда",
                    date = "16.10.2023",
                    imageUrl = listOf(
                        "https://www.kstu.ru/servlet/contentblob?id=474142"
                    ),
                    text = "aasdasda",
                    newsType = "Университетская жизнь",
                    newsId = 1,
                ),
                onNewsClick = {}
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewNewsCard_dark() {
    PreviewNewsCard()
}

@Preview
@Composable
private fun PreviewNewsCard_light() {
    PreviewNewsCard()
}
