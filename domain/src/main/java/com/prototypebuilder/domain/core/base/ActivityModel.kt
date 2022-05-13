package com.prototypebuilder.domain.core.base

import com.prototypebuilder.domain.core.enum.WidgetType

data class ActivityModel(
    val screenName: String,
    val screenId: String,
    val ui: List<WidgetModel>,
)
