package com.hugidonic.kstuscheduler.presentation.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme

@Composable
fun Header() {
	Card(
		modifier = Modifier
			.background(MaterialTheme.colors.surface)
	) {
		Column {
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 10.dp, vertical = 18.dp)
			) {
				Text(text="Группа: 1211-22")
				Text(text="Неделя: нечет")
			}

			ScrollableCalendar()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewHeader() {
	MainAppTheme {
		Header()
	}
}