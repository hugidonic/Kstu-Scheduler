package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import android.widget.Switch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.schedule.LocalScheduleActions
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleActions
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleState
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme

@Composable
fun Header(
	state: ScheduleState = ScheduleState(),
	actions: ScheduleActions
) {
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
				WeekTypeSwitcher(
					currentType = state.currentTypeOfWeek,
					onChangeType = actions.onChangeTypeOfWeek
				)
			}
			CalendarTabs(
				onDayOfWeekClick = actions.onDayOfWeekClick,
				currentPage = state.activeScheduleDayIdx
			)
		}
	}
}

@Composable
fun PreviewHeader(type: String = "Нечет") {
	MainAppTheme {
		Header(
			actions = ScheduleActions(),
			state = ScheduleState(
				currentTypeOfWeek = type
			)
		)
	}
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark")
@Composable
fun PreviewHeaderDark() {
	PreviewHeader()
}

@Preview(name = "Light")
@Composable
fun PreviewHeaderLight() {
	PreviewHeader(type = "Чет")
}