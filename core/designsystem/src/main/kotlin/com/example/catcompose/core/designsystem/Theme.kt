package com.example.catcompose.core.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal val LightColorScheme =
    lightColorScheme(
        primary = Orange500,
        onPrimary = Color.White,
        secondary = Orange800,
        background = DeepSpace,
        onBackground = Color.White,
        surface = DeepSpace,
        onSurface = Color.White,
    )

@Composable
public fun CatTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content,
    )
}
