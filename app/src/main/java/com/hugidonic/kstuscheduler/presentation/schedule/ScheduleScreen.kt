package com.hugidonic.kstuscheduler.presentation.schedule

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.schedule.components.Header
import com.hugidonic.kstuscheduler.presentation.schedule.components.SubjectRow
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme

@Composable
fun ScheduleScreen(
    state: ScheduleState = ScheduleState(),
    actions: ScheduleActions = ScheduleActions()
) {
    val ACTIVE_IDX = 2
    Column {
        Header()
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            itemsIndexed(
                items=(1..10).toList()
            ) {idx, item ->
                val isActive = idx == ACTIVE_IDX
                SubjectRow(isActive)
            }
        }
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun PreviewScheduleScreenDark() {
    MainAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            ScheduleScreen(
                state = ScheduleState()
            )
        }
    }
}

@Preview()
@Composable
fun PreviewScheduleScreenLight() {
    MainAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            ScheduleScreen(
                state = ScheduleState()
            )
        }
    }
}
