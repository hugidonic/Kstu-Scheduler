package com.hugidonic.kstuscheduler.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.theme.MainAppTheme

@Composable
fun SubjectLine(
	isActive: Boolean = false,
	cardHeight: Dp,
) {
	Column(
		modifier=Modifier.heightIn(min=cardHeight),
		horizontalAlignment = Alignment.End,
	) {
		EllipseImage(isActive)

		Row(
			horizontalArrangement = Arrangement.End,
			modifier = Modifier
				.weight(1f)
				.padding(end = 9.dp, top = 4.dp),
		) {
			Column (
				verticalArrangement = Arrangement.SpaceBetween,
				modifier = Modifier.fillMaxHeight().padding(end=5.dp)
			) {
				Text(
					text="11:20",
					style=MaterialTheme.typography.body2,
				)
				Text(
					text="12:50",
					style=MaterialTheme.typography.caption,
				)
			}
			Box(
				modifier = Modifier
					.width(2.dp)
					.height(cardHeight)
					.background(MaterialTheme.colors.primary)
				,
			)
		}
	}
}

@Preview
@Composable
fun PreviewSubjectLine() {
	MainAppTheme {
		Surface {
			SubjectLine(
				isActive = false,
				cardHeight = 130.dp,
			)
		}
	}
}