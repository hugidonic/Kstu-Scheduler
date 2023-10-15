package com.hugidonic.kstuscheduler.presentation.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hugidonic.kstuscheduler.presentation.utils.Constants

@Composable
fun SubjectRowTimeBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .width(Constants.SUBJECT_DIVIDER_WIDTH)
            .fillMaxHeight()
    )
}
