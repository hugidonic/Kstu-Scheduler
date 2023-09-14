package com.hugidonic.kstuscheduler.presentation.schedule

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.schedule.components.Header
import com.hugidonic.kstuscheduler.presentation.schedule.components.SubjectsList
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.utils.DummyData

@Composable
fun ScheduleScreen(
    state: ScheduleState = ScheduleState(),
    actions: ScheduleActions = ScheduleActions()
) {
    Column {
        Header(state = state, actions)
        if (state.weekScheduleDays.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
            SubjectsList(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                subjects = state.weekScheduleDays[state.activeScheduleDayIdx].subjects,
            )
        }
    }
}

@Composable
fun PreviewScheduleScreen() {
    MainAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            ScheduleScreen(
                state = ScheduleState(
                    isLoading = false,
                    weekScheduleDays = DummyData.weekSchedule,
                    activeScheduleDayIdx = 0,
                    currentTypeOfWeek = "Чет"
                ),
                actions = ScheduleActions()
            )
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun PreviewScheduleScreenDark() {
    PreviewScheduleScreen()
}

@Preview(name = "Light")
@Composable
fun PreviewScheduleScreenLight() {
    PreviewScheduleScreen()
}
