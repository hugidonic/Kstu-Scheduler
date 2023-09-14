package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.hugidonic.domain.models.SubjectModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
@OptIn(ExperimentalFoundationApi::class)
class ScheduleCoordinator(
    val viewModel: ScheduleViewModel,
    val pagerState: PagerState,
    val scope: CoroutineScope,
    val pagerPage: MutableIntState
) {
    val screenStateFlow = viewModel.stateFlow

    fun onDayOfWeekClick(dayOfWeekIdx: Int) {
        pagerPage.intValue = dayOfWeekIdx
        scope.launch { pagerState.animateScrollToPage(dayOfWeekIdx) }
        viewModel.onDayOfWeekClick(dayOfWeekIdx)
    }

    fun onChangeTypeOfWeek() {
        viewModel.changeTypeOfWeek()
    }

    fun onSubjectClick(subject: SubjectModel) {
        // TODO handle subject click
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberScheduleCoordinator(
    viewModel: ScheduleViewModel = hiltViewModel(),
): ScheduleCoordinator {
    val scope = rememberCoroutineScope()

    val pagerPage = remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        pagerPage.intValue
    }

    return remember(viewModel) {
        ScheduleCoordinator(
            viewModel = viewModel,
            pagerPage = pagerPage,
            pagerState = pagerState,
            scope = scope,
        )
    }
}