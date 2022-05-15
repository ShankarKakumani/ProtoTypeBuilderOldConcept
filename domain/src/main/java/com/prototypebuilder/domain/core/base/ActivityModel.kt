package com.prototypebuilder.domain.core.base

data class ActivityModel(
    val activityId: Long = 0,
    val appId: Long,
    val activityName: String? = null,
    val background: Int? = null,
    val statusBarColor: Int? = null,
    val statusBarDarkIcons: Boolean? = null,
    val navigationBarColor: Int? = null,
    val navigationBarDarkIcons: Boolean? = null,
)
