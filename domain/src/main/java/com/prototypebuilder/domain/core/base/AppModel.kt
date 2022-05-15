package com.prototypebuilder.domain.core.base

data class AppModel(
    val appId: Long = 0,
    val appName: String? = null,
    val background: Int? = null,
    val statusBarColor: Int? = null,
    val statusBarDarkIcons: Boolean? = null,
    val navigationBarColor: Int? = null,
    val navigationBarDarkIcons: Boolean? = null,
    val themeType: String? = null,
    val initialScreenId: Int? = null,
)
