package com.hugidonic.kstuscheduler.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.hugidonic.kstuscheduler.presentation.navigation.AppNavGraph
import com.hugidonic.kstuscheduler.presentation.navigation.bottombar.BottomNavigationBar
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
					Scaffold(
						drawerElevation = 0.dp,
						bottomBar = { BottomNavigationBar(navController = navController) },
					) {padding ->
						AppNavGraph(navHostController = navController, padding = padding)
					}
				}
			}
		}
	}
}




