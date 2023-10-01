package com.hugidonic.kstuscheduler.presentation.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.R
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import com.hugidonic.kstuscheduler.presentation.navigation.bottombar.BottomNavItem

object Constants {

    val SPLASH_SCREEN_DELAY: Long = 1500L

    val WEEKDAYS_LIST = arrayListOf(
        "Пн",
        "Вт",
        "Ср",
        "Чт",
        "Пт",
        "Сб",
    )

    val SUBJECT_COL_WIDTH = 44.dp
    val SUBJECT_DIVIDER_WIDTH = 2.dp
    val ELLIPSE_PADDING = 5.dp

    fun getEllipseSize(isActive: Boolean): Dp {
        return if (isActive) 20.dp else 12.dp
    }

    fun getSubjectSpacerWidth(isActive: Boolean): Dp {
        val size = getEllipseSize(isActive)
        return SUBJECT_COL_WIDTH + SUBJECT_DIVIDER_WIDTH/2 - size/2
    }



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
