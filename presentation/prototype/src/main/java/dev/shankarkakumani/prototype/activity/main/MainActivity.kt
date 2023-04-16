package dev.shankarkakumani.prototype.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dev.shankarkakumani.resources.enums.WidgetType.*
import dev.shankarkakumani.resources.models.WidgetModel
import dev.shankarkakumani.resources.widgets.TextFieldWidget
import dev.shankarkakumani.resources.widgets.TextViewWidget

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen().SetupUI()
        }


    }

    @Composable
    fun RunThroughWhen(widget: WidgetModel) {
        when (widget.widgetType) {
            TextView -> TextViewUI(widget.widgetData)
            EditText -> EditTextUI(widget.widgetData)
            Button -> TODO()
            LazyColumn -> TODO()
        }
    }

    @Composable
    fun TextViewUI(gson: String) {
        val widget = Gson().fromJson(gson, TextViewWidget::class.java)

        Text(text = widget.text)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EditTextUI(gson: String) {
        val widget = Gson().fromJson(gson, TextFieldWidget::class.java)
        TextField(value = widget.text, onValueChange = {})
    }

}
