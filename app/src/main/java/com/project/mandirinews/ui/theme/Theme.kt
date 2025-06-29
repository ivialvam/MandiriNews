package com.project.mandirinews.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.project.mandirinews.R


private val MandiriLightColorScheme = lightColorScheme(
    primary = MandiriBlue,
    onPrimary = Color.White,
    secondary = MandiriGold,
    onSecondary = Color.White,
    background = Color(0xFFF8F9FA),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

private val MandiriDarkColorScheme = darkColorScheme(
    primary = MandiriBlue,
    onPrimary = Color.White,
    secondary = MandiriGold,
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White
)

val MandiriTypography = Typography(
    headlineSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 12.sp
    )
)



@Composable
fun MandiriNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> MandiriDarkColorScheme
        else -> MandiriLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MandiriTypography,
        content = content
    )
}