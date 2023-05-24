package com.hugidonic.kstuscheduler.presentation.schedule.components

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
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.utils.bottomBorder


@Composable
fun ScrollableCalendar() {
	val ITEM_WIDTH: Float = 1/6f
	val ACTIVE_IDX = 1

	val weekDayList = listOf<String>(
		"Пн",
		"Вт",
		"Ср",
		"Чт",
		"Пт",
		"Сб",
	)

	LazyRow(
		modifier = Modifier.fillMaxWidth(),
	) {
		itemsIndexed(
			items = (1..20).toList(),
		) { idx, item ->
			val activeDp = if (idx == ACTIVE_IDX) 2.dp else 0.dp
			val weekIdx = idx % 6
			Column(
				modifier = Modifier
					.fillParentMaxWidth(ITEM_WIDTH)
					.bottomBorder(activeDp, MaterialTheme.colors.primary)
					.padding(10.dp),
				verticalArrangement = Arrangement.SpaceBetween,
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				Text(
					text=weekDayList[weekIdx],
					style=MaterialTheme.typography.body2,
					color=MaterialTheme.colors.secondary
				)
				Text(
					text=(14+idx).toString(),
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
			ScrollableCalendar()
		}
	}
}