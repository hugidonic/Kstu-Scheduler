package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.utils.WEEKDAYS_LIST

@Composable
fun CalendarTabs(
    modifier: Modifier = Modifier,
    currentPage: Int,
    onDayOfWeekClick: (Int) -> Unit,
) {
    val WEEK_DAYS_COUNT = 6
    val ITEM_WIDTH: Float = 1 / WEEK_DAYS_COUNT.toFloat()

    val selectedTabIndex = minOf(
        WEEKDAYS_LIST.count(),
        currentPage
    )

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = MaterialTheme.colors.surface,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = MaterialTheme.colors.primary,
                height = 2.dp
            )
        },
    ) {
        WEEKDAYS_LIST.forEachIndexed { idx, weekDayName ->
            Tab(
                enabled = true,
                selected = currentPage == idx,
                onClick = {
                      onDayOfWeekClick(idx)
                },
                modifier = Modifier.fillMaxWidth(ITEM_WIDTH),
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = weekDayName,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
        }
    }
}

@Composable
fun PreviewCalendarTabs() {
    MainAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CalendarTabs(
                currentPage = 0,
                onDayOfWeekClick = {}
            )
        }
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun PreviewCalendarTabsDark() {
    PreviewCalendarTabs()
}

@Preview(name = "Light")
@Composable
fun PreviewCalendarTabsLight() {
    PreviewCalendarTabs()
}
