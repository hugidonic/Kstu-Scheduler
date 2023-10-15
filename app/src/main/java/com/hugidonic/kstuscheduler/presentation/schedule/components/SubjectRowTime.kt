package com.hugidonic.kstuscheduler.presentation.schedule.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.utils.Constants

@Composable
fun SubjectRowTime(
    modifier: Modifier = Modifier,
    startTime: String,
    endTime: String,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .fillMaxHeight()
            .width(Constants.SUBJECT_COL_WIDTH)
            .padding(end = 6.dp)
    ) {
        Text(
            text = startTime,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = endTime,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}