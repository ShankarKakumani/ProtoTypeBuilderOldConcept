/**
 * Author : Mani Shankar Kakumani,
 * Created on : 14 May, 2022.
 */

package com.prototypebuilder.app.views.appInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.prototypebuilder.domain.core.base.ActivityModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppInfoActivity : ComponentActivity(), AppInfoNavigator {

    companion object {
        private const val keyAppId = "appId"
        fun intent(
            context: Context,
            appId: Long,
        ): Intent {
            val intent = Intent(context, AppInfoActivity::class.java).apply {
                putExtra(keyAppId, appId)
            }
            return intent
        }
    }

    private val appId: Long? by lazy {
        intent?.getLongExtra(keyAppId, -1)
    }

    private val viewModel: AppInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {
        setComposeContent()
        setupNavigator()
        handleIntentData()
        getDataFromDatabase()
    }

    private fun getDataFromDatabase() {
        (appId ?: return).let {
            viewModel.getActivityListByAppId(it)
        }
    }

    private fun setupNavigator() {
        viewModel.setUpNavigator(this)
    }

    private fun setComposeContent() {

        setContent {
            AppInfoCompose().SetUpUI()
        }

    }

    private fun handleIntentData() {
        appId?.let { id ->
            viewModel.getAppById(id)
        }
    }

    override fun addNewActivity() {
        viewModel.insertActivity(
            ActivityModel(
                appId = appId ?: return,
                activityName = "New Activity"
            )
        )
    }

}