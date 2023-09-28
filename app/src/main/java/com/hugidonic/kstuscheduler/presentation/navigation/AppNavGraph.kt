package com.hugidonic.kstuscheduler.presentation.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hugidonic.kstuscheduler.presentation.profile.ProfileScreen
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleRoute

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navHostController,
        startDestination = "schedule",
        popEnterTransition = {
            fadeIn(
                animationSpec = tween(durationMillis = 300),
                initialAlpha = 0.99f
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(durationMillis = 300),
                targetAlpha = 0.99f
            )
        }
    ) {
        composable("schedule") {
            ScheduleRoute()
        }

        composable("profile") {
            ProfileScreen()
        }
    }
}