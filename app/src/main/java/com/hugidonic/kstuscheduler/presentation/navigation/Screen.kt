package com.hugidonic.kstuscheduler.presentation.navigation

sealed class Screen(val route: String) {
    object Schedule : Screen("home")
    object Profile: Screen("profile")
    object Splash: Screen("splash")

    object SubjectDetails: Screen("subject_details/{subjectId}") {
        fun createRoute(subjectId: Int) = "subject_details/$subjectId"
    }

    object PrepodDetails: Screen("prepod_details") {
        fun createRoute(prepodId: Int) = "prepod_details/$prepodId"
    }
}
