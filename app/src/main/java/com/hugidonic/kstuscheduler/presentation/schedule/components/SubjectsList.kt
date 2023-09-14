package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.utils.DummyData
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun SubjectsList(
    modifier: Modifier = Modifier,
    subjects: List<SubjectModel>,
) {
    if (subjects.isEmpty()) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize().padding(top = 20.dp)
        ) {
            Text(text = "Нет пар", style = MaterialTheme.typography.body1, color = MaterialTheme.colors.secondary)
        }
    }
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = subjects,
        ) { classSubject ->
            val isActive = isSubjectActive(startTime = classSubject.startTime, endTime = classSubject.endTime)
            SubjectRow(
                subject = classSubject, isActive = isActive
            )
        }
    }
}

fun isSubjectActive(startTime: String, endTime: String): Boolean {
    val startTimeDate = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"))
    val endTimeDate = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"))
    val currentTime = LocalTime.now()
    return currentTime in startTimeDate..endTimeDate
}

@Composable
private fun PreviewClassesList() {
    MainAppTheme {
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            SubjectsList(
                modifier = Modifier.padding(20.dp), subjects = DummyData.weekSchedule[3].subjects
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