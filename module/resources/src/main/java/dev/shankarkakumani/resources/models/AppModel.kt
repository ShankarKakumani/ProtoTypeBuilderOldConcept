package dev.shankarkakumani.resources.models

data class AppModel(
    val appId: String,
    val appName: String,
    val screenList: List<ScreenModel>
)