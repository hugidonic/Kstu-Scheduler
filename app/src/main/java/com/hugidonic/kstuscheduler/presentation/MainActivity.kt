package com.hugidonic.kstuscheduler.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.hugidonic.kstuscheduler.presentation.screens.ScheduleScreen
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
					ScheduleScreen()
				}
			}
		}
	}
}




