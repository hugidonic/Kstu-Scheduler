package com.hugidonic.kstuscheduler.presentation.schedule

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import com.hugidonic.kstuscheduler.presentation.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
@OptIn(ExperimentalFoundationApi::class)
class ScheduleCoordinator(
    val viewModel: ScheduleViewModel,
    val pagerState: PagerState,
    val scope: CoroutineScope,
    val pagerPage: MutableIntState,
    val navController: NavController
) {
    val screenStateFlow = viewModel.stateFlow

    fun onDayOfWeekClick(dayOfWeekIdx: Int) {
        pagerPage.intValue = dayOfWeekIdx
        scope.launch { pagerState.animateScrollToPage(dayOfWeekIdx) }
    }

    fun onChangeTypeOfWeek() {
        viewModel.changeTypeOfWeek()
    }

    fun onSubjectClick(subjectId: Int) {
        navController.navigate(Screen.SubjectDetails.createRoute(subjectId = subjectId))
    }

    fun onEditGroupClick(newGroup: String) {
        val validated = validateGroup(newGroup)
        viewModel.editGroup(newGroup = validated)
    }

    private fun validateGroup(newGroup: String): String {
        var validated = newGroup.trim()
        validated = validated.replace("\n", "")
        return validated
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberScheduleCoordinator(
    viewModel: ScheduleViewModel = hiltViewModel(),
    navController: NavController
): ScheduleCoordinator {
    val scope = rememberCoroutineScope()

    val pagerPage = remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState(
        initialPage = viewModel.currentDayOfWeek,
        initialPageOffsetFraction = 0f
    ) {
        Constants.WEEKDAYS_LIST.size
    }

    return remember(viewModel) {
        ScheduleCoordinator(
            viewModel = viewModel,
            pagerPage = pagerPage,
            pagerState = pagerState,
            scope = scope,
            navController = navController
        )
    }
}