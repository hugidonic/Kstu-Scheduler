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
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.Red100
import com.hugidonic.kstuscheduler.presentation.ui.theme.White
import com.hugidonic.kstuscheduler.presentation.utils.DummyData

@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    subjectInfo: SubjectModel,
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
                text = subjectInfo.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = if (isSystemInDarkTheme()) White else Red100,
                style = MaterialTheme.typography.h1,
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                SubjectInfoColumn(
                    modifier = Modifier.weight(1f),
                    subtitle1 = subjectInfo.type,
                    subtitle2 = subjectInfo.prepod
                )
                SubjectInfoColumn(
                    modifier = Modifier.weight(1f),
                    subtitle1 = subjectInfo.cabinet,
                    subtitle2 = subjectInfo.duration
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
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = subtitle1,
            style = MaterialTheme.typography.subtitle1,
        )
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = subtitle2,
            style = MaterialTheme.typography.caption,
        )
    }
}

@Composable
fun PreviewSubjectCard() {
    MainAppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ) {
            val subject = DummyData.weekSchedule[3].subjects[0]
            SubjectCard(subjectInfo = subject)
        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun PreviewSubjectCardDark() {
    PreviewSubjectCard()
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    name = "Light"
)
@Composable
fun PreviewSubjectCardLight() {
    PreviewSubjectCard()
}