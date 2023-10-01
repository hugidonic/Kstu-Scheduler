package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.schedule.LocalScheduleActions
import com.hugidonic.kstuscheduler.presentation.schedule.ScheduleActions
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.Red100
import com.hugidonic.kstuscheduler.presentation.ui.theme.White

@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    subjectInfo: SubjectModel,
    scheduleActions: ScheduleActions = LocalScheduleActions.current
) {

    Card(
        modifier = modifier
            .padding(5.dp)
            .clickable {
                scheduleActions.onSubjectClick(subjectInfo.subjectId)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(15.dp),
        ) {
            Text(
                text = subjectInfo.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = if (isSystemInDarkTheme()) White else MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineMedium,
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                SubjectInfoColumn(
                    modifier = Modifier.weight(1f),
                    titleMedium = subjectInfo.type,
                    titleSmall = subjectInfo.prepod
                )
                SubjectInfoColumn(
                    modifier = Modifier.weight(1f),
                    titleMedium = subjectInfo.cabinet,
                    titleSmall = subjectInfo.duration
                )
            }
        }
    }
}

@Composable
fun SubjectInfoColumn(
    modifier: Modifier = Modifier,
    titleMedium: String,
    titleSmall: String,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = titleMedium,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = titleSmall,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PreviewSubjectCard() {
    AppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            val subject = DummyData.weekSchedule[3].subjects[0]
            SubjectCard(subjectInfo = subject, scheduleActions = ScheduleActions())
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