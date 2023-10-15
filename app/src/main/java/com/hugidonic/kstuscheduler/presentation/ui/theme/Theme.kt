package com.hugidonic.kstuscheduler.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val AppLightColorScheme = lightColorScheme(
    primary = Red200,
    onPrimary = White,

    secondary = Red300,
    onSecondary = White,

    tertiary = Mixed600,
    onTertiary = White,

    background = OffWhite,
    onBackground = Black,

    surface = White,
    onSurface = Black,
    surfaceTint = Red100,

    error = Red200,
    onError = White,
    errorContainer = Red100,
)

val AppDarkColorScheme = darkColorScheme(
    primary = Red300,
    onPrimary = White,

    secondary = Red200,
    onSecondary = White,

    tertiary = Dark600,
    onTertiary = White,

    background = Dark100,
    onBackground = White,

    surface = Dark200,
    onSurface = White,
    surfaceTint = Red300,

    error = Red100,
    onError = White,
    errorContainer = Red300,
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) AppDarkColorScheme else AppLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        shapes = AppShapes,
        typography = AppTypography,
    )
}
