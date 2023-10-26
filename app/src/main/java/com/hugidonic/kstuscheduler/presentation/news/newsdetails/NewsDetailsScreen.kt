package com.hugidonic.kstuscheduler.presentation.news.newsdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.shared.LoadingCircle
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailsScreen(
    state: NewsDetailsState = NewsDetailsState(),
    actions: NewsDetailsActions = NewsDetailsActions()
) {

    val sheetState = rememberModalBottomSheetState(
        
    )
    val scope = rememberCoroutineScope()
    var isBottomSheetShown by remember {
        mutableStateOf(false)
    }
    if (state.newsDetails == null) {
        LoadingCircle()
    } else {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiary)
                    .fillMaxWidth()
                    .height(300.dp)
            )
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { isBottomSheetShown = false }
            ) {
                // Sheet content
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            isBottomSheetShown = false
                        }
                    }
                }) {
                    Text("Hide bottom sheet")
                }
            }
        }
    }
}

@Composable
@Preview(name = "NewsDetails")
private fun NewsDetailsScreenPreview() {
    NewsDetailsScreen()
}

