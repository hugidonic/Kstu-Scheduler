package com.hugidonic.kstuscheduler.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.theme.MainAppTheme

@Composable
fun SubjectCard(
	modifier: Modifier = Modifier
) {
	Card(
		modifier=modifier,
		shape = RoundedCornerShape(8.dp),
		elevation = 5.dp,
	) {
		Column(
			modifier = Modifier.padding(15.dp),
		) {
			Text(
				text="Основы информационной Основы информационной Основы информационной Основы " +
						"информационнойОсновы информационнойОсновы информационной",
				maxLines = 2,
				overflow = TextOverflow.Ellipsis,
				style = MaterialTheme.typography.h1,
			)
			Row(modifier=Modifier.padding(top = 10.dp)) {
				Column(
					modifier = Modifier.weight(1f)
				) {
					Text(
						text="Лекция",
						style = MaterialTheme.typography.body2,
					)
					Text(
						text="Богомолов В.А.",
						style = MaterialTheme.typography.caption,
					)
				}
				Column(
					modifier = Modifier.weight(1f)
				) {
					Text(
						text="Ауд: И-1-209",
						style = MaterialTheme.typography.body2,
					)
					Text(
						text="1 сен - 1 янв",
						style = MaterialTheme.typography.caption,
					)
				}
			}
		}
	}
}


@Preview
@Composable
fun PreviewSubjectCard() {
	MainAppTheme {
		Surface {
			SubjectCard()
		}
	}
}