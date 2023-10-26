package com.hugidonic.kstuscheduler.presentation.navigation

sealed class Screen(val route: String) {
    data object Schedule : Screen("home")
    data object Profile : Screen("profile")
    data object Splash : Screen("splash")

    data object News : Screen("news")

    data object NewsDetails : Screen("news/{newsId}") {
        fun createRoute(newsId: Int) = "news/$newsId"
    }

    data object SubjectDetails : Screen("subject_details/{subjectId}") {
        fun createRoute(subjectId: Int) = "subject_details/$subjectId"
    }

    data object PrepodDetails : Screen("prepod_details/{prepodId}") {
        fun createRoute(prepodId: Int) = "prepod_details/$prepodId"
    }
}
