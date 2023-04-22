package com.hugidonic.kstuscheduler.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.Red100

@Composable
fun SubjectRow(
	isActive: Boolean = false
) {
	val COL_WIDTH = 40.dp
	val DIVIDER_WIDTH = 2.dp
	val size = if (isActive) 20.dp else 12.dp
	val SPACER_WIDTH = COL_WIDTH + DIVIDER_WIDTH/2 - size/2
	val ELLIPSE_PADDING = 5.dp

	Column {
		Row(
			modifier = Modifier
				.height(IntrinsicSize.Min)
				.padding(vertical = ELLIPSE_PADDING)
		) {
			Spacer(modifier = Modifier.width(SPACER_WIDTH))
			EllipseImage(
				isActive = isActive,
				modifier = Modifier.size(size)
			)
		}
		Row(
			modifier = Modifier.height(IntrinsicSize.Min)
		) {
			Column (
				verticalArrangement = Arrangement.SpaceBetween,
				horizontalAlignment = Alignment.End,
				modifier = Modifier
					.fillMaxHeight()
					.width(COL_WIDTH)
					.padding(end=6.dp)
			) {
				Text(
					text="11:20",
					style= MaterialTheme.typography.body2,
				)
				Text(
					text="12:50",
					style= MaterialTheme.typography.caption,
					color= MaterialTheme.colors.secondary
				)
			}
			Box(
				modifier = Modifier
					.background(Red100)
					.width(DIVIDER_WIDTH)
					.fillMaxHeight()
			)
			SubjectCard(
				modifier = Modifier.weight(1f).padding(start = 10.dp),
				subjectTitle="Основы Информационной безопасности и корпораций "
			)
		}
	}

}


@Preview
@Composable
fun PreviewSubjectRow() {
	MainAppTheme {
		Surface(color = Color.LightGray) {
			Column {
				SubjectRow(isActive = false)
				SubjectRow(isActive = true)
			}
		}
	}
}