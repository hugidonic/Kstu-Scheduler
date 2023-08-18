package com.hugidonic.kstuscheduler.presentation.schedule.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.utils.DayOfWeek
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.utils.bottomBorder
import java.util.*


@Composable
fun Calendar(
	activeDayOfWeek: DayOfWeek = DayOfWeek.Mon,
	onDayOfWeekClick: (dayOfWeek: DayOfWeek) -> Unit = {}
) {
	val ITEM_WIDTH: Float = 1/6f
//	we show only 6 days mon-sat
	val WEEK_DAYS_COUNT = 6

	val weekDayList = listOf<String>(
		"Пн",
		"Вт",
		"Ср",
		"Чт",
		"Пт",
		"Сб",
	)

	val calendar = Calendar.getInstance()
	val today = calendar.get(Calendar.DAY_OF_MONTH)
	val curDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1 // 1-6 where 1 is monday and 6 is saturday

	val fromDate = today - (curDayOfWeek - 1)

	LazyRow(
		modifier = Modifier.fillMaxWidth(),
	) {
		itemsIndexed(
			items = (1..WEEK_DAYS_COUNT).toList(),
		) { idx, _ ->
			val activeDp = if (idx == activeDayOfWeek.ordinal) 2.dp else 0.dp
			Column(
				modifier = Modifier
					.fillParentMaxWidth(ITEM_WIDTH)
					.bottomBorder(activeDp, MaterialTheme.colors.primary)
					.clickable {
					}
					.padding(10.dp),
				verticalArrangement = Arrangement.SpaceBetween,
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				Text(
					text=weekDayList[idx],
					style=MaterialTheme.typography.body2,
					color=MaterialTheme.colors.secondary
				)
				Text(
					text=(fromDate+idx).toString(),
					style=MaterialTheme.typography.body1
				)
			}
		}
	}
}

@Preview
@Composable
fun PreviewScrollableCalendar() {
	MainAppTheme {
		Surface {
			Calendar()
		}
	}
}