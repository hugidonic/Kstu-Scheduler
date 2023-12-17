package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.hugidonic.kstuscheduler.presentation.shared.LoadingCircle
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailsScreen(
    state: NewsDetailsState = NewsDetailsState(),
    actions: NewsDetailsActions = NewsDetailsActions()
) {
    val sheetState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    var isBottomSheetShown by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        if (state.newsDetails == null) {
            LoadingCircle()
        } else {
            BottomSheetScaffold(
                scaffoldState = sheetState,
                modifier = Modifier.fillMaxHeight().verticalScroll(rememberScrollState()),
                sheetPeekHeight = 530.dp,
                sheetSwipeEnabled = true,
                sheetContent = {
                    Column(
                        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = state.newsDetails.text,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(state.newsDetails.imageUrl[0])
                        .crossfade(true)
                        .build(),
                    loading = {
                        LoadingCircle(size = 50.dp, strokeWidth = 5.dp)
                    },
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "news image",
                    modifier = Modifier
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = size.height/3,
                                endY = size.height
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(brush = gradient, blendMode = BlendMode.Multiply)
                            }
                        }
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }
        }
    }
}

@Composable
@Preview(name = "NewsDetails")
private fun NewsDetailsScreenPreview() {
    NewsDetailsScreen()
}

