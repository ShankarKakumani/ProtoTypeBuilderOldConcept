package com.prototypebuilder.app.views.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.gson.Gson
import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.core.base.WidgetModel
import com.prototypebuilder.domain.core.enum.WidgetType
import com.prototypebuilder.domain.core.widget.TextFieldWidget
import com.prototypebuilder.domain.core.widget.TextViewWidget
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = ActivityModel(
            "Screen1", "56789876",
            getUIList()
        )

        setContent {
            MainCompose().SetUpUI()
        }

    }

    private fun getUIList(): List<WidgetModel> {
        return listOf(
            WidgetModel("456789", "One", WidgetType.TextView, getTextViewData()),
            WidgetModel("234543", "Two", WidgetType.EditText, getTextFieldData()),
            WidgetModel("234543", "Three", WidgetType.TextView, getTextViewData()),
            WidgetModel("245433", "Four", WidgetType.EditText, getTextFieldData()),
        )
    }

    private fun getTextViewData(): String {
        val obj = TextViewWidget("I am Text")
        return Gson().toJson(obj)
    }


    private fun getTextFieldData(): String {
        val obj = TextFieldWidget("I am EditText", "I am Hint")
        return Gson().toJson(obj)
    }


}

