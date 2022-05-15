package com.prototypebuilder.domain.core.base

data class AppModel(
    val appId: Long = 0,
    val appName: String? = null,
    val background: String? = null,
    val statusBarColor: String? = null,
    val statusBarDarkIcons: Boolean? = null,
    val navigationBarColor: String? = null,
    val navigationBarDarkIcons: Boolean? = null,
    val themeType: String? = null,
    val initialScreenId: Int? = null,
)
