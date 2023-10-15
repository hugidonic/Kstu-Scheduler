package com.hugidonic.kstuscheduler.presentation.prepoddetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.prepoddetails.components.DetailsHeader
import com.hugidonic.kstuscheduler.presentation.prepoddetails.components.PrepodBio
import com.hugidonic.kstuscheduler.presentation.prepoddetails.components.PrepodSubjectTaught
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

@Composable
fun PrepodDetailsScreen(
    state: PrepodDetailsState = PrepodDetailsState(),
    actions: PrepodDetailsActions = PrepodDetailsActions()
) {
    if (state.prepodDetails == null) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Round,
                modifier = Modifier.size(100.dp)
            )
        }
    } else {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            DetailsHeader()
            Spacer(modifier = Modifier.height(15.dp))
            PrepodSubjectTaught(subjectsTaught = state.prepodDetails.subjects_taught)
            Spacer(modifier = Modifier.height(15.dp))
            PrepodBio(bio = state.prepodDetails.bio)
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
private fun PrepodDetailsScreenPreview() {
    AppTheme {
        Surface {
            PrepodDetailsScreen()
        }
    }
}

@Preview
@Composable
private fun PrepodDetailsScreenPreview_dark() {
    PrepodDetailsScreenPreview()
}

@Preview
@Composable
private fun PrepodDetailsScreenPreview_light() {
    PrepodDetailsScreenPreview()
}