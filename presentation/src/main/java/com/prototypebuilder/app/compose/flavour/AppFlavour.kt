/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.app.compose.flavour

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.prototypebuilder.app.R
import com.prototypebuilder.app.compose.values.*

object AppFlavour {


    val LocalColor = staticCompositionLocalOf {
        simpleOneLightColors()
    }

    val LocalIcons = staticCompositionLocalOf {
        simpleOneLightIcons()
    }

    val LocalStrings = staticCompositionLocalOf {
        simpleOneStrings()
    }

    val LocalFonts = staticCompositionLocalOf {
        simpleOneFonts()
    }

    val LocalTypography = staticCompositionLocalOf {
        simpleOneTypo()
    }

    fun simpleOneLightColors() = CustomColorPack(
        primaryColor = Color.White,
        colorPrimaryVariant = Color.White,
        secondaryColor = Color.Blue,
        walkThroughBackground = Color.White,
        whiteToBlack = Color.White,
        blackToWhite = Color.Black,
    )

    fun simpleOneDarkColors() = CustomColorPack(
        primaryColor = Color.Black,
        colorPrimaryVariant = Color.Black,
        secondaryColor = Color.Green,
        splashBackground = Color.Black,
        whiteToBlack = Color.Black,
        blackToWhite = Color.White,
    )

    fun simpleOneLightIcons() = CustomIconPack(
        appIcon = R.drawable.ic_launcher_foreground,
    )

    private fun simpleOneStrings() = CustomStringPack(
        appName = R.string.app_name,
    )

    private fun simpleOneFonts() = CustomFontPack(
        inter = interFontFamily
    )

    private fun simpleOneTypo() = CustomTypography()

}

