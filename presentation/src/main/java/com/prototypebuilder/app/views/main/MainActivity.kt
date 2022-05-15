package com.prototypebuilder.app.views.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.prototypebuilder.app.utils.navigateAway
import com.prototypebuilder.app.views.appInfo.AppInfoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainNavigator {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {
        setComposeContent()
        setNavigator()
    }

    private fun setComposeContent() {
        setContent {
            MainCompose().SetUpUI()
        }
    }

    private fun setNavigator() {
        viewModel.setUpNavigator(this)
    }

    override fun gotoAppInfo(appId: Long) {
        val intent = AppInfoActivity.intent(this, appId)
        navigateAway(intent)
    }

}

