package com.hugidonic.kstuscheduler.presentation.prepoddetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hugidonic.kstuscheduler.presentation.ui.theme.RobotoRegular

@Composable
fun PrepodSubjectTaught(
    modifier: Modifier = Modifier,
    subjectsTaught: List<String>
) {
    val bullet = "\u2022"
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
        ) {
            Text(text = "Преподаваемые дисциплины", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(10.dp))
            val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
            val regularSpanStyle = SpanStyle(
                fontFamily = RobotoRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                buildAnnotatedString {
                    subjectsTaught.forEach {subj ->
                        withStyle(style = paragraphStyle) {
                            append(bullet)
                            append("\t\t")
                            withStyle(style = regularSpanStyle) {
                                append(subj)
                            }
                        }
                    }
                }
            )
        }
    }
}