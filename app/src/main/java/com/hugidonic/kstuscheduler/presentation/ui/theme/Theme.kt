package com.hugidonic.kstuscheduler.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
	primary = Red300,
	primaryVariant = Red200,
	secondary = Dark600,

	background = Dark100,
	onBackground = White,
	surface = Dark200,
)

private val LightColorPalette = lightColors(
	primary = Red100,
	primaryVariant = Red200,
	secondary = Dark600,

    background = OffWhite,
	onBackground = Dark100,
    surface = White,
	onSurface = Dark100,
)

@Composable
fun MainAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () ->
Unit) {
	val colors = if (darkTheme) {
		DarkColorPalette
	} else {
		LightColorPalette
	}

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}