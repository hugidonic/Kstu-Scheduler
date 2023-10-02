package com.hugidonic.kstuscheduler.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleRoute
import com.hugidonic.kstuscheduler.presentation.splash.AnimatedSplashScreen
import com.hugidonic.kstuscheduler.presentation.subjectdetails.SubjectDetailsRoute

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    padding: PaddingValues? = null,
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route,
        popEnterTransition = {
            fadeIn(
                animationSpec = tween(durationMillis = 100),
                initialAlpha = 0.99f
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(durationMillis = 100),
                targetAlpha = 0.99f
            )
        }
    ) {
        composable(Screen.Splash.route) {
            AnimatedSplashScreen(navController = navHostController)
        }

        composable(Screen.Schedule.route) {
            ScheduleRoute(navController = navHostController)
        }

        composable(
            Screen.SubjectDetails.route,
            arguments = listOf(navArgument("subjectId") {
                type = NavType.IntType
            })
        ) {
            SubjectDetailsRoute()
        }
    }
}