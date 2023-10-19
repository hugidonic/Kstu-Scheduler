package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.navigation.ShowBars
import com.hugidonic.kstuscheduler.presentation.schedule.components.Header
import com.hugidonic.kstuscheduler.presentation.schedule.components.SubjectsList
import com.hugidonic.kstuscheduler.presentation.shared.pullToRefresh.PullRefreshIndicator
import com.hugidonic.kstuscheduler.presentation.shared.pullToRefresh.pullRefresh
import com.hugidonic.kstuscheduler.presentation.shared.pullToRefresh.rememberPullRefreshState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScheduleScreen(
    state: ScheduleState = ScheduleState(),
    actions: ScheduleActions = ScheduleActions(),
    pagerState: PagerState,
) {
    val refreshing by remember {
        mutableStateOf(false)
    }
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = actions.onRefresh)

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
                    Box(modifier = Modifier.pullRefresh(refreshState)) {
                        SubjectsList(
                            modifier = Modifier
                                .fillMaxSize(),
                            subjects = state.weekScheduleDays[index].subjects,
                            scheduleDate = state.weekScheduleDays[index].date,
                        )
                        PullRefreshIndicator(refreshing = refreshing, state = refreshState, modifier = Modifier.align(Alignment.TopCenter))
                    }
                }
            }
        }
}