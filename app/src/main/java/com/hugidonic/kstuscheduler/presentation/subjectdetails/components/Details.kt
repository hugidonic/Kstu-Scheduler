package com.hugidonic.kstuscheduler.presentation.subjectdetails.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.RobotoBold
import com.hugidonic.kstuscheduler.presentation.ui.theme.RobotoRegular

@Composable
fun Details(
    modifier: Modifier = Modifier,
    subjectInfo: SubjectModel,
    onPrepodClick: (prepodId: Int) -> Unit
) {

    val textColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.primary

    val boldSpanStyle = SpanStyle(
        fontFamily = RobotoBold,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = textColor
    )

    val regularSpanStyle = SpanStyle(
        fontFamily = RobotoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onSurface
    )

    Column(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "${subjectInfo.title} (${subjectInfo.shortTitle})",
                    style = MaterialTheme.typography.displaySmall,
                    color = textColor
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Преподаватель:",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = subjectInfo.prepod,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
                        onPrepodClick(0)
                    },
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = regularSpanStyle
                    ) {
                        append("Корпус: ")
                    }
                    withStyle(style = boldSpanStyle) {
                        append(subjectInfo.cabinet[0])
                    }
                    append("   ")
                    withStyle(
                        style = regularSpanStyle
                    ) {
                        append("Аудитория: ")
                    }
                    withStyle(style = boldSpanStyle) {
                        append(subjectInfo.cabinet)
                    }
                })
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = regularSpanStyle
                    ) {
                        append("Тип дисциплины: ")
                    }
                    withStyle(
                        style = boldSpanStyle
                    ) {
                        append(subjectInfo.type)
                    }
                })
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = regularSpanStyle
                    ) {
                        append("Продолжительность: ")
                    }
                    withStyle(
                        style = boldSpanStyle
                    ) {
                        append(subjectInfo.duration)
                    }
                })
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = regularSpanStyle
                    ) {
                        append("Начало занятия: ")
                    }
                    withStyle(
                        style = boldSpanStyle
                    ) {
                        append(subjectInfo.startTime)
                    }
                })
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = regularSpanStyle
                    ) {
                        append("Конец занятия: ")
                    }
                    withStyle(
                        style = boldSpanStyle
                    ) {
                        append(subjectInfo.endTime)
                    }
                })
            }
        }
    }
}

@Composable
private fun PreviewDetails() {
    AppTheme {
        Surface {
            Details(
                modifier = Modifier.padding(10.dp),
                subjectInfo = DummyData.weekSchedule[3].subjects[0],
                onPrepodClick = {}
            )
        }
    }
}

@Preview(name = "light")
@Composable
private fun PreviewDetails_light() {
    PreviewDetails()
}

@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDetails_dark() {
    PreviewDetails()
}