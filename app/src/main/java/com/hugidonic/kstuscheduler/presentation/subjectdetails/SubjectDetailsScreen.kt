package com.hugidonic.kstuscheduler.presentation.subjectdetails

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.subjectdetails.components.Details
import com.hugidonic.kstuscheduler.presentation.subjectdetails.components.KorpusMap
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

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
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Round,
                modifier = Modifier.size(100.dp)
            )
        }
    } else {
        val subjectInfo = state.subjectDetails
        val subjectKorpus = if (subjectInfo.cabinet == "МИРАС") "МИРАС" else subjectInfo.cabinet[0].toString()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            KorpusMap(korpus = subjectKorpus)
            Details(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp), subjectInfo = subjectInfo)
        }
    }
}

@Composable
private fun SubjectDetailsScreenPreview() {
    AppTheme {
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

