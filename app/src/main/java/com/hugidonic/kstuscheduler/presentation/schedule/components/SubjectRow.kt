package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import com.hugidonic.kstuscheduler.presentation.utils.Constants


@Composable
fun SubjectRow(
    subject: SubjectModel,
    isDisabled: Boolean = false,
    isActive: Boolean = false,
) {
    val ELLIPSE_SIZE = Constants.getEllipseSize(isActive)
    val SPACER_WIDTH = Constants.getSubjectSpacerWidth(isActive)
    Column(
        modifier = Modifier.alpha(if (isDisabled) .5f else 1f)
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(vertical = Constants.ELLIPSE_PADDING)
        ) {
            Spacer(modifier = Modifier.width(SPACER_WIDTH))
            EllipseImage(
                isActive = isActive,
                modifier = Modifier.size(ELLIPSE_SIZE)
            )
        }
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(Constants.SUBJECT_COL_WIDTH)
                    .padding(end = 6.dp)
            ) {
                Text(
                    text = subject.startTime,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = subject.endTime,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(Constants.SUBJECT_DIVIDER_WIDTH)
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