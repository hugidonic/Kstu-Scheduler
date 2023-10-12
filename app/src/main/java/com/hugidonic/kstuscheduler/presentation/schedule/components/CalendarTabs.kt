package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import com.hugidonic.kstuscheduler.presentation.utils.Constants

@Composable
fun CalendarTabs(
    modifier: Modifier = Modifier,
    currentPage: Int,
    onDayOfWeekClick: (Int) -> Unit,
) {
    val WEEK_DAYS_COUNT = 6
    val ITEM_WIDTH: Float = 1 / WEEK_DAYS_COUNT.toFloat()

    val selectedTabIndex = minOf(
        Constants.WEEKDAYS_LIST.size,
        currentPage
    )

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.surface,
        divider = {},
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = MaterialTheme.colorScheme.primary,
                height = 2.dp
            )
        },
    ) {
        Constants.WEEKDAYS_LIST.forEachIndexed { idx, weekDayName ->
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
                        .padding(5.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = weekDayName,
                        style = if (currentPage == idx) {
                            MaterialTheme.typography.headlineSmall
                        } else {
                            MaterialTheme.typography.labelLarge
                        },
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Composable
fun PreviewCalendarTabs() {
    AppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
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
