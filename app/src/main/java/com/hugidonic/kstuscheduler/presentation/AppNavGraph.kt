package com.hugidonic.kstuscheduler.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleRoute
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleScreen
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleViewModel

@Composable
fun AppNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "schedule") {
        composable("schedule") {
            val scheduleViewModel = hiltViewModel<ScheduleViewModel>()
            ScheduleRoute()
        }
    }
}