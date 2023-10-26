package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.schedule.SubjectState
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme


@Composable
fun SubjectRow(
    subject: SubjectModel,
    subjectState: SubjectState = SubjectState.DEFAULT,
) {
    val isActive = subjectState == SubjectState.ACTIVE
    val isDisabled = subjectState == SubjectState.DISABLED

    Column(
        modifier = Modifier.alpha(if (isDisabled) .5f else 1f)
    ) {
        EllipseWithSpace(
            isActive = isActive
        )
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            SubjectRowTime(startTime = subject.startTime, endTime = subject.endTime)
            SubjectRowTimeBar()
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
    AppTheme {
        Surface(
            modifier = Modifier.padding(10.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                val subjects = DummyData.weekSchedule[3].subjects
                SubjectRow(
                    subject = subjects[0],
                    subjectState = SubjectState.DISABLED
                )
                SubjectRow(
                    subject = subjects[0],
                    subjectState = SubjectState.ACTIVE
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