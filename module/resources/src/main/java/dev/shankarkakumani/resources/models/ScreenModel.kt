package dev.shankarkakumani.resources.models

data class ScreenModel(
    val screenId: String,
    val appId: String,
    val screenName: String,
    val widgetsList: List<WidgetModel>
)
