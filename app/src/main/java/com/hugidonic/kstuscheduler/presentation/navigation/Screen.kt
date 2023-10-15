package com.hugidonic.kstuscheduler.presentation.navigation

sealed class Screen(val route: String) {
    data object Schedule : Screen("home")
    data object Profile : Screen("profile")
    data object Splash : Screen("splash")

    data object SubjectDetails : Screen("subject_details/{subjectId}") {
        fun createRoute(subjectId: Int) = "subject_details/$subjectId"
    }

    data object PrepodDetails : Screen("prepod_details/{prepodId}") {
        fun createRoute(prepodId: Int) = "prepod_details/$prepodId"
    }
}
