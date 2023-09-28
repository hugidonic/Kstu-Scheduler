package com.hugidonic.kstuscheduler.presentation.navigation.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hugidonic.kstuscheduler.presentation.utils.Constants

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.shadow(
            elevation = 10.dp,
            spotColor = MaterialTheme.colors.onSurface
        ),
        elevation = 10.dp,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Constants.BottomNavItems.forEach { screen ->
                BottomTab(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}
