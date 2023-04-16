package dev.shankarkakumani.resources.widgets

import dev.shankarkakumani.resources.models.WidgetModel

data class LazyColumnWidget(
    val list: List<WidgetModel>
) : Widget()