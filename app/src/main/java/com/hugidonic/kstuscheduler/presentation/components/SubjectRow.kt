package com.hugidonic.kstuscheduler.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme

@Composable
fun SubjectRow(
	isActive: Boolean = false
) {
	Row(
		verticalAlignment = Alignment.Bottom,
		modifier = Modifier
			.fillMaxWidth()
			.padding(start = 16.dp, end = 16.dp, bottom=4.dp)
			.height(IntrinsicSize.Min)
	) {
		SubjectLine(
			isActive = isActive,
			cardHeight = 108.dp,
		)
		SubjectCard(
			modifier = Modifier
				.width(280.dp)
				.weight(1f)
		)
	}
}


@Preview
@Composable
fun PreviewSubjectRow() {
	MainAppTheme {
		Surface {
			SubjectRow()
		}
	}
}