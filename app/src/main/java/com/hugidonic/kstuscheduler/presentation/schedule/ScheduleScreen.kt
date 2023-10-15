package com.hugidonic.kstuscheduler.presentation.schedule

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.hugidonic.kstuscheduler.presentation.utils.Constants
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.kstuscheduler.presentation.navigation.ShowBars
import com.hugidonic.kstuscheduler.presentation.schedule.components.Header
import com.hugidonic.kstuscheduler.presentation.schedule.components.SubjectsList
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScheduleScreen(
    state: ScheduleState = ScheduleState(),
    actions: ScheduleActions = ScheduleActions(),
    pagerState: PagerState
) {
    ShowBars(flag = true)

    Column {
        Header(
            group = state.group,
            currentTypeOfWeek = state.currentTypeOfWeek,
            actions = actions,
            currentPage = pagerState.currentPage
        )
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { index ->
                if (state.isLoading || state.weekScheduleDays.isNullOrEmpty()) {
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
                    SubjectsList(
                        modifier = Modifier
                            .fillMaxSize(),
                        subjects = state.weekScheduleDays[index].subjects,
                        scheduleDate = state.weekScheduleDays[index].date,
                    )
                }
            }
        }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviewScheduleScreen() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ScheduleScreen(
                state = ScheduleState(
                    isLoading = false,
                    weekScheduleDays = DummyData.weekSchedule,
                    currentTypeOfWeek = "Нечет"
                ),
                actions = ScheduleActions(),
                pagerState = rememberPagerState(
                    initialPage = 0,
                ) {
                    Constants.WEEKDAYS_LIST.size
                }
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
