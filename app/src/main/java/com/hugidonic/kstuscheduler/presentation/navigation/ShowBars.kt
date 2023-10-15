package com.hugidonic.kstuscheduler.presentation.navigation

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ShowBars(flag: Boolean) {
    rememberSystemUiController().apply {
        this.isStatusBarVisible = flag
        this.isNavigationBarVisible = flag
        this.isSystemBarsVisible = flag
    }
}