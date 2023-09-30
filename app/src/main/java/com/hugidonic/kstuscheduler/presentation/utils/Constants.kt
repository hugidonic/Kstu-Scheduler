package com.hugidonic.kstuscheduler.presentation.utils

import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.R
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import com.hugidonic.kstuscheduler.presentation.navigation.bottombar.BottomNavItem

object Constants {

    val SPLASH_SCREEN_DELAY: Long = 2500L

    val WEEKDAYS_LIST = arrayListOf(
        "Пн",
        "Вт",
        "Ср",
        "Чт",
        "Пт",
        "Сб",
    )

    val BottomNavigationHeight = 56.dp

    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Расписание",
            icon = R.drawable.schedule,
            route = Screen.Schedule.route
        ),
        BottomNavItem(
            label = "Профиль",
            icon = R.drawable.user,
            route = Screen.Profile.route
        ),
    )
}
