/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.app.views.magic

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import com.google.gson.Gson
import com.prototypebuilder.domain.core.widget.TextFieldWidget
import com.prototypebuilder.domain.core.widget.TextViewWidget

class MagicCompose {

    @Composable
    fun TextViewUI(widgetData: String) {
        val data = Gson().fromJson(widgetData, TextViewWidget::class.java)
        data?.let {
            Text(text = it.text)
        }
    }


    @Composable
    fun TextFieldUI(widgetData: String) {
        val data = Gson().fromJson(widgetData, TextFieldWidget::class.java)
        data?.let {
            TextField(value = it.text, onValueChange = {})
        }
    }

}