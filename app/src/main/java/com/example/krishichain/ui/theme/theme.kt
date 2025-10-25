package com.example.krishichain.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape

private val LightColors = lightColorScheme(
    primary = Color(0xFF388E3C),
    onPrimary = Color.White,
    secondary = Color(0xFF8BC34A),
    onSecondary = Color.Black,
    background = Color(0xFFF5F5F5),
    onBackground = Color(0xFF212121),
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFD32F2F),
    onError = Color.White
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF66BB6A),
    onPrimary = Color.Black,
    secondary = Color(0xFF9CCC65),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    error = Color(0xFFEF5350),
    onError = Color.Black
)

private val KrishiTypography = Typography(
    displayLarge = Typography().displayLarge.copy(color = Color(0xFF2E7D32)),
    headlineMedium = Typography().headlineMedium.copy(color = Color(0xFF388E3C)),
    bodyMedium = Typography().bodyMedium.copy(color = Color(0xFF333333)),
    labelSmall = Typography().labelSmall.copy(color = Color(0xFF616161))
)

private val KrishiShapes = Shapes(
    small = RoundedCornerShape(8),
    medium = RoundedCornerShape(12),
    large = RoundedCornerShape(20)
)

data class KrishiSpacing(
    val extraSmall: Double = 4.0,
    val small: Double = 8.0,
    val medium: Double = 16.0,
    val large: Double = 24.0,
    val extraLarge: Double = 32.0
)

val LocalSpacing = compositionLocalOf { KrishiSpacing() }

@Composable
fun KrishiChainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    CompositionLocalProvider(LocalSpacing provides KrishiSpacing()) {
        MaterialTheme(
            colorScheme = colors,
            typography = KrishiTypography,
            shapes = KrishiShapes,
            content = content
        )
    }
}
