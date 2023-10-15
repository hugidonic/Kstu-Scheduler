package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleActions
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleState
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

@Composable
fun Header(
    group: String,
    currentTypeOfWeek: String,
    actions: ScheduleActions,
    currentPage: Int,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .shadow(elevation = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 12.dp)
        ) {
            GroupTextField(
                group = group,
                editGroup = actions.onEditGroup
            )
            WeekTypeSwitcher(
                currentType = currentTypeOfWeek,
                onChangeType = actions.onChangeTypeOfWeek
            )
        }
        CalendarTabs(
            onDayOfWeekClick = actions.onDayOfWeekClick,
            currentPage = currentPage
        )
    }
}

@Composable
fun PreviewHeader(type: String = "Нечет") {
    AppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            Header(
                actions = ScheduleActions(),
                group = "1211-22",
                currentTypeOfWeek = "Нечет",
                currentPage = 3
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark")
@Composable
fun PreviewHeaderDark() {
    PreviewHeader()
}

@Preview(name = "Light")
@Composable
fun PreviewHeaderLight() {
    PreviewHeader(type = "Чет")
}