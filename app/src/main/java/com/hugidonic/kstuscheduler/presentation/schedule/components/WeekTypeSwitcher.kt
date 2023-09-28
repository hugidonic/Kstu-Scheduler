package com.hugidonic.kstuscheduler.presentation.schedule.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.ui.theme.DarkSurface
import com.hugidonic.kstuscheduler.presentation.ui.theme.LightSurface
import com.hugidonic.kstuscheduler.presentation.ui.theme.MainAppTheme

@Composable
fun WeekTypeSwitcher(
    modifier: Modifier = Modifier,
    currentType: String,
    onChangeType: () -> Unit,
) {
    val bg = if (isSystemInDarkTheme()) DarkSurface else LightSurface
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .background(
                bg
            )
            .padding(horizontal = 20.dp, vertical = 6.dp)
            .clickable {
                onChangeType()
            },
    ) {
        Text(
            text = "${currentType}ная",
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
private fun PreviewWeekTypeSwitcher() {
    MainAppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(15.dp)
        ) {
            WeekTypeSwitcher(currentType = "Чет", onChangeType = {})
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark")
@Composable
fun PreviewWeekTypeSwitcherDark() {
    PreviewWeekTypeSwitcher()
}

@Preview(name = "Light")
@Composable
fun PreviewWeekTypeSwitcherLight() {
    PreviewWeekTypeSwitcher()
}