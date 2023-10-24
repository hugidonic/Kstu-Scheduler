package com.hugidonic.kstuscheduler.presentation.navigation.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.hugidonic.kstuscheduler.presentation.ui.theme.DarkSurface
import com.hugidonic.kstuscheduler.presentation.ui.theme.LightSurface

@Composable
fun BottomTab(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background =
        if (selected) {
            if (isSystemInDarkTheme()) DarkSurface else LightSurface
        } else {
            Color.Transparent
        }

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
//                    TODO: wtf...
                    navController.popBackStack()
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(screen.icon),
                contentDescription = screen.label,
                modifier = Modifier.size(24.dp)
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.label,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
