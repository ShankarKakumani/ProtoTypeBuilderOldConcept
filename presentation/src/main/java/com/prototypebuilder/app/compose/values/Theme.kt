/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.app.compose.values

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import com.prototypebuilder.app.compose.flavour.AppFlavour


fun getFlavour() = AppFlavour

object AppTheme {
    val colors: CustomColorPack
        @Composable
        @ReadOnlyComposable
        get() = getFlavour().LocalColor.current

    val icons: CustomIconPack
        @Composable
        @ReadOnlyComposable
        get() = getFlavour().LocalIcons.current

    val strings: CustomStringPack
        @Composable
        @ReadOnlyComposable
        get() = getFlavour().LocalStrings.current

    val fonts: CustomFontPack
        @Composable
        @ReadOnlyComposable
        get() = getFlavour().LocalFonts.current

    val typo: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = getFlavour().LocalTypography.current
}

@Composable
fun getAppColors() = AppTheme.colors

@Composable
fun getAppIcons() = AppTheme.icons

@Composable
fun getAppStrings() = AppTheme.strings

@Composable
fun getAppFonts() = AppTheme.fonts

@Composable
fun getAppTypo() = AppTheme.typo

@Composable
fun AppTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (isDarkColor(isDark)) {
        getFlavour().simpleOneLightColors()
    } else {
        getFlavour().simpleOneLightColors()
    }

    val icons = if (isDarkColor(isDark)) {
        getFlavour().simpleOneLightIcons()
    } else {
        getFlavour().simpleOneLightIcons()
    }

    CompositionLocalProvider(
        getFlavour().LocalColor provides colors,
        getFlavour().LocalIcons provides icons,
    ) {
        content()
    }

}

@Composable
fun isDarkColor(isSystemInDark: Boolean): Boolean {
    return when (ThemeState.darkModeState.value) {
        ThemeType.MODE_AUTO -> {
            isSystemInDark
        }
        ThemeType.MODE_LIGHT -> {
            false
        }
        ThemeType.MODE_DARK -> {
            true
        }
    }
}

object ThemeState {
    var darkModeState: MutableState<ThemeType> = mutableStateOf(ThemeType.MODE_LIGHT)
}

object ScreenSize {
    var screenWidth: MutableState<Double> = mutableStateOf(375.0)
    var screenHeight: MutableState<Double> = mutableStateOf(667.0)
}


enum class ThemeType {
    MODE_LIGHT,
    MODE_DARK,
    MODE_AUTO
}
