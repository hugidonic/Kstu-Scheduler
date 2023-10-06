package com.hugidonic.kstuscheduler.presentation.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.models.KorpusModel
import com.hugidonic.kstuscheduler.R
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import com.hugidonic.kstuscheduler.presentation.navigation.bottombar.BottomNavItem

object Constants {

    val KORPUS_ll = mapOf(
        "А" to KorpusModel(55.794772,49.138037),
        "Б" to KorpusModel(55.794532,49.141166),
        "В" to KorpusModel(55.793814,49.140636),
        "Г" to KorpusModel(55.806728,49.186783),
        "Д" to KorpusModel(55.807526,49.184426),
        "Е" to KorpusModel(55.807106,49.185949),
        "И" to KorpusModel(55.823296,49.182380),
        "К" to KorpusModel(55.793769,49.139009),
        "Л" to KorpusModel(55.807834,49.185717),
        "М" to KorpusModel(55.806728,49.186783),
        "О" to KorpusModel(55.794554,49.140065),
        "Т" to KorpusModel(55.792167,49.139157),
        "МИРАС" to KorpusModel(55.791065,49.228641)
    )

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
        return SUBJECT_COL_WIDTH + SUBJECT_DIVIDER_WIDTH / 2 - size / 2
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
