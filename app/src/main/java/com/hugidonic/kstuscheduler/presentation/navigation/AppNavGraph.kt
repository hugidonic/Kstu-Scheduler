package com.hugidonic.kstuscheduler.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hugidonic.kstuscheduler.presentation.news.NewsRoute
import com.hugidonic.kstuscheduler.presentation.news.newsdetails.NewsDetailsRoute
import com.hugidonic.kstuscheduler.presentation.prepoddetails.PrepodDetailsRoute
import com.hugidonic.kstuscheduler.presentation.profile.ProfileRoute
import com.hugidonic.kstuscheduler.presentation.profile.ProfileScreen
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleRoute
import com.hugidonic.kstuscheduler.presentation.splash.AnimatedSplashScreen
import com.hugidonic.kstuscheduler.presentation.subjectdetails.SubjectDetailsRoute

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    snackbarHostState: SnackbarHostState,
    padding: PaddingValues,
) {

    NavHost(
        navController = navHostController,
        modifier = Modifier.padding(padding),
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
            ScheduleRoute(navController = navHostController, snackbarHostState = snackbarHostState)
        }

        composable(
            Screen.SubjectDetails.route,
            arguments = listOf(navArgument("subjectId") {
                type = NavType.IntType
            })
        ) {
            SubjectDetailsRoute(navController = navHostController)
        }

        composable(
            Screen.PrepodDetails.route,
            arguments = listOf(navArgument("prepodId") {
                type = NavType.IntType
            })
        ) {
            PrepodDetailsRoute()
        }

        composable(Screen.Profile.route) {
            ProfileRoute()
        }
        
        composable(Screen.News.route) {
            NewsRoute(navController = navHostController,  snackbarHostState = snackbarHostState)
        }

        composable(
            route = Screen.NewsDetails.route,
            arguments = listOf(navArgument("newsId") {
                type = NavType.IntType
            })
        ) {
            NewsDetailsRoute()
        }
    }
}