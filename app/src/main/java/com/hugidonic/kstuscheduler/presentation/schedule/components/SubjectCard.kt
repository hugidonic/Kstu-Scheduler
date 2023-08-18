package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.Red100
import com.hugidonic.kstuscheduler.presentation.ui.theme.White

@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    subjectTitle: String = "Основы информационной безопасности",
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
        ) {
            Text(
                text = subjectTitle,
                maxLines = 2,
                color = if (isSystemInDarkTheme()) White else Red100,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h1,
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                SubjectInfoColumn(
                    modifier = Modifier.weight(1f),
                    subtitle1 = "Лекция",
                    subtitle2 = "Богомолов В.А."
                )
                SubjectInfoColumn(
                    modifier = Modifier.weight(1f),
                    subtitle1 = "Ауд: И-1-209",
                    subtitle2 = "1 сен - 1 янв"
                )

            }
        }
    }
}

@Composable
fun SubjectInfoColumn(
    modifier: Modifier = Modifier,
    subtitle1: String,
    subtitle2: String,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = subtitle1,
            style = MaterialTheme.typography.subtitle1,
        )
        Text(
            text = subtitle2,
            style = MaterialTheme.typography.caption,
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun PreviewSubjectCardDark() {
    MainAppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ) {
            SubjectCard(
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    name = "Light"
)
@Composable
fun PreviewSubjectCardLight() {
    MainAppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ) {
            SubjectCard(
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}