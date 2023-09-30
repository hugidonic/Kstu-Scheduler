package com.hugidonic.kstuscheduler.presentation.subjectdetails

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.subjectdetails.components.Details
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import java.util.*

@Composable
fun SubjectDetailsScreen(
    state: SubjectDetailsState = SubjectDetailsState(),
    actions: SubjectDetailsActions = SubjectDetailsActions()
) {
    if (state.isLoading || state.subjectDetails == null) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Round,
                modifier = Modifier.size(100.dp)
            )
        }
    } else {
        val subjectInfo = state.subjectDetails
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .background(MaterialTheme.colors.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Map", style = MaterialTheme.typography.h1)
            }
            Details(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),subjectInfo = subjectInfo)
        }
    }
}

@Composable
private fun SubjectDetailsScreenPreview() {
    MainAppTheme {
        Surface {
            SubjectDetailsScreen()
        }
    }
}

@Preview(name = "Light")
@Composable
fun SubjectDetailsScreenPreview_light() {
    SubjectDetailsScreenPreview()
}

@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SubjectDetailsScreenPreview_dark() {
    SubjectDetailsScreenPreview()
}

