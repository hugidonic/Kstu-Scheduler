package com.hugidonic.kstuscheduler.presentation.subjectdetails.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme
import com.hugidonic.kstuscheduler.presentation.ui.theme.RobotoBold
import com.hugidonic.kstuscheduler.presentation.ui.theme.RobotoMedium
import com.hugidonic.kstuscheduler.presentation.ui.theme.RobotoRegular
import com.hugidonic.kstuscheduler.presentation.utils.DummyData

@Composable
fun Details(
    modifier: Modifier = Modifier,
    subjectInfo: SubjectModel
) {
    Column(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 5.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "${subjectInfo.title} (${subjectInfo.shortTitle})",
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.primaryVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 5.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Преподаватель:",
                    style = MaterialTheme.typography.subtitle1,
                )
                Text(
                    text = subjectInfo.prepod,
                    style = MaterialTheme.typography.body1,
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = RobotoRegular,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    ) {
                        append("Корпус: ")
                    }
                    withStyle(style = SpanStyle(fontFamily = RobotoBold, fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                        append(subjectInfo.cabinet[0])
                    }
                    append("   ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = RobotoRegular,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    ) {
                        append("Аудитория: ")
                    }
                    withStyle(style = SpanStyle(fontFamily = RobotoBold,fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                        append(subjectInfo.cabinet)
                    }
                })
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    append("Тип дисциплины: ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = RobotoRegular,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    ) {
                        append(subjectInfo.type)
                    }
                })
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    append("Продолжительность: ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = RobotoRegular,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    ) {
                        append(subjectInfo.duration)
                    }
                })
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 5.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(text = buildAnnotatedString {
                    append("Начало занятия:")
                    withStyle(style = SpanStyle(fontFamily = RobotoBold, fontSize = 14.sp)) {
                        append(subjectInfo.startTime)
                    }
                })
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = buildAnnotatedString {
                    append("Конец занятия:")
                    withStyle(style = SpanStyle(fontFamily = RobotoBold, fontSize = 14.sp)) {
                        append(subjectInfo.endTime)
                    }
                })
            }
        }
    }
}

@Composable
private fun PreviewDetails() {
    MainAppTheme {
        Surface {
            Details(
                modifier = Modifier.padding(10.dp),
                subjectInfo = DummyData.weekSchedule[3].subjects[0]
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