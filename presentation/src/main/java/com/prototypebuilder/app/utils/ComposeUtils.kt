
/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.app.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.prototypebuilder.app.compose.values.ScreenSize

object ComposeUtils {

    @Composable
    fun SetUpSystemUiColors(
        statusBarColor: Color = Color.White,
        statusBarDarkIcons: Boolean = true,
        navigationBarColor: Color = Color.White,
        navigationBarDarkIcons: Boolean = true
    ) {
        RefreshScreenSize()
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(statusBarColor, statusBarDarkIcons)
        systemUiController.setNavigationBarColor(
            navigationBarColor,
            darkIcons = navigationBarDarkIcons
        )
    }


    @Composable
    fun RefreshScreenSize() {
        val screenWidth = LocalConfiguration.current.screenWidthDp
        val screenHeight = LocalConfiguration.current.screenHeightDp
        ScreenSize.screenWidth.value = screenWidth.toDouble()
        ScreenSize.screenHeight.value = screenHeight.toDouble()
    }


}
