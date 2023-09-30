package com.hugidonic.kstuscheduler.presentation.schedule

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.navigation.ShowBars
import com.hugidonic.kstuscheduler.presentation.schedule.components.Header
import com.hugidonic.kstuscheduler.presentation.schedule.components.SubjectsList
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.utils.DummyData
import java.time.LocalDate

@Composable
fun ScheduleScreen(
    state: ScheduleState = ScheduleState(),
    actions: ScheduleActions = ScheduleActions()
) {
    ShowBars(flag = true)
    val currentScheduleDay = if (state.activeScheduleDayIdx < state.weekScheduleDays.size) {
        state.weekScheduleDays[state.activeScheduleDayIdx]
    } else {
       null
    }

    Column {
        Header(state = state, actions)
        if (state.isLoading) {
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
            SubjectsList(
                modifier = Modifier
                    .fillMaxSize()
                ,
                subjects = currentScheduleDay?.subjects ?: emptyList(),
                scheduleDate = currentScheduleDay?.date ?: LocalDate.now().toString()
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
                    currentTypeOfWeek = "Нечет"
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
