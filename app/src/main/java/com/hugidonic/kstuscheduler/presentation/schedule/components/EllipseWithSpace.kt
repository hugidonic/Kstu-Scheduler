package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import com.hugidonic.kstuscheduler.presentation.utils.Constants

@Composable
fun EllipseWithSpace(
    modifier: Modifier = Modifier,
    isActive: Boolean
) {
    val SPACER_WIDTH = Constants.getSubjectSpacerWidth(isActive = isActive)
    val ELLIPSE_SIZE = Constants.getEllipseSize(isActive = isActive)
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .padding(vertical = Constants.ELLIPSE_PADDING)
    ) {
        Spacer(modifier = Modifier.width(SPACER_WIDTH))
        EllipseImage(
            isActive = isActive,
            modifier = Modifier.size(ELLIPSE_SIZE)
        )
    }
}

@Composable
private fun PreviewScheduleRowTimeBar() {
    AppTheme {
        Surface {
            EllipseWithSpace(
                isActive = true
            )
        }
    }
}

@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewScheduleRowTimeBar_dark() {
    PreviewScheduleRowTimeBar()
}

@Preview(name = "Light")
@Composable
fun PreviewScheduleRowTimeBar_light() {
    PreviewScheduleRowTimeBar()
}