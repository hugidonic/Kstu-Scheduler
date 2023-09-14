package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.Red100
import com.hugidonic.kstuscheduler.presentation.utils.DummyData
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@Composable
fun SubjectRow(
	subject: SubjectModel,
	isActive: Boolean = false,
) {
	val size = if (isActive) 20.dp else 12.dp
	val COL_WIDTH = 40.dp
	val DIVIDER_WIDTH = 2.dp
	val SPACER_WIDTH = COL_WIDTH + DIVIDER_WIDTH/2 - size/2
	val ELLIPSE_PADDING = 5.dp

	Column() {
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
					.padding(end = 6.dp)
			) {
				Text(
					text = subject.startTime,
					style= MaterialTheme.typography.body2,
				)
				Text(
					text = subject.endTime,
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
				modifier = Modifier
					.weight(1f)
					.padding(start = 10.dp),
				subjectInfo = subject,
			)
		}
	}
}

@Composable
fun PreviewClassSubject() {
	MainAppTheme {
		Surface(color = MaterialTheme.colors.background) {
			Column(
				modifier = Modifier.padding(20.dp)
			) {
				val subjects = DummyData.weekSchedule[3].subjects
				SubjectRow(
					subject = subjects[0],
				)
				SubjectRow(
					subject = subjects[0],
				)
			}
		}
	}
}

@Preview(
	uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark"
)
@Composable
fun PreviewClassSubjectDark() {
	PreviewClassSubject()
}

@Preview(name = "Light")
@Composable
fun PreviewClassSubjectLight() {
	PreviewClassSubject()
}