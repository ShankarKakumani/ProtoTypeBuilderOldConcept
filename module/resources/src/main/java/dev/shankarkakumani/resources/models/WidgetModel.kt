package dev.shankarkakumani.resources.models

import dev.shankarkakumani.resources.enums.WidgetType

data class WidgetModel(
    val widgetId: String,
    val widgetName: String,
    val widgetType: WidgetType,
    val widgetData: String
)