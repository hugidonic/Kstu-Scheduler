package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleParser
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import com.hugidonic.kstuscheduler.presentation.utils.Constants

@Composable
fun SubjectsList(
    modifier: Modifier = Modifier,
    subjects: List<SubjectModel>,
    scheduleDate: String,
) {
    if (subjects.isEmpty()) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Нет пар",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    } else {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                bottom = Constants.BottomNavigationHeight + 16.dp
            ),

            ) {
            items(
                items = subjects,
            ) { classSubject ->
                val subjectState =
                    ScheduleParser.getSubjectState(
                        date = scheduleDate,
                        startTime = classSubject.startTime,
                        endTime = classSubject.endTime
                    )
                SubjectRow(
                    subject = classSubject,
                    subjectState = subjectState
                )
            }
            item {
                EllipseWithSpace(
                    isActive = false
                )
            }
            }
        }
}

@Composable
private fun PreviewClassesList() {
    AppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            SubjectsList(
                modifier = Modifier.padding(20.dp), subjects = DummyData.weekSchedule[3].subjects,
                scheduleDate = DummyData.weekSchedule[3].date
            )
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark"
)
@Composable
private fun PreviewClassesListDark() {
    PreviewClassesList()
}

@Preview(name = "Light")
@Composable
private fun PreviewClassesListLight() {
    PreviewClassesList()
}