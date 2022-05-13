package com.prototypebuilder.domain.core.base

import com.prototypebuilder.domain.core.enum.WidgetType

data class WidgetModel(
    val widgetId: String,
    val widgetName: String,
    val widgetType: WidgetType,
    val widgetData: String
)
