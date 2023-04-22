package com.hugidonic.kstuscheduler.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.components.Header
import com.hugidonic.kstuscheduler.presentation.components.SubjectRow
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme

@Composable
fun ScheduleScreen() {
	val ACTIVE_IDX = 2
	Column {
		Header()
		LazyColumn (
			modifier = Modifier.fillMaxSize().padding(vertical = 15.dp),
		) {
			itemsIndexed(
				items=(1..10).toList()
			) {idx, item ->
				val isActive = if (idx == ACTIVE_IDX) true else false
				SubjectRow(isActive)
			}
		}
	}
}

@Preview()
@Composable
fun PreviewScheduleScreen() {
	MainAppTheme {
		Surface(color = MaterialTheme.colors.background) {
			ScheduleScreen()
		}
	}
}