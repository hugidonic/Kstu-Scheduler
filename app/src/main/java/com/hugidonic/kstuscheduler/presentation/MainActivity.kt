package com.hugidonic.kstuscheduler.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hugidonic.kstuscheduler.presentation.navigation.AppNavGraph
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import com.hugidonic.kstuscheduler.presentation.navigation.topbar.TopBar
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MainAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					val navController = rememberNavController()

					val navBackStackEntry by navController.currentBackStackEntryAsState()

					var isTopBarVisible by rememberSaveable { (mutableStateOf(true)) }

					// Control TopBar and BottomBar
					when (navBackStackEntry?.destination?.route) {
						Screen.SubjectDetails.route, Screen.PrepodDetails.route -> {
							isTopBarVisible = true
						}

						else -> {
							isTopBarVisible = false
						}
					}

					Scaffold(
						drawerElevation = 0.dp,
						topBar = {
							if (isTopBarVisible) {
								TopBar(navController = navController)
							}
						},
					) {padding ->
						AppNavGraph(navHostController = navController, padding = padding)
					}
				}
			}
		}
	}
}

@Stable
@Composable
private fun NavHostController.shouldShowBottomNavigationAsState(): State<Boolean> {
	val shouldShowBottomNavigation = remember { mutableStateOf(false) }

	DisposableEffect(this) {
		val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
			shouldShowBottomNavigation.value = destination.route != Screen.Splash.route
		}
		addOnDestinationChangedListener(listener)
		onDispose {
			removeOnDestinationChangedListener(listener)
		}
	}

	return shouldShowBottomNavigation
}




