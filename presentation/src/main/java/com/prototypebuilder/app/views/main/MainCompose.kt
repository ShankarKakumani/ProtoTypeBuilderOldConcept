/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.app.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prototypebuilder.app.R
import com.prototypebuilder.app.compose.layouts.ShowAlertDialog
import com.prototypebuilder.app.utils.ComposeUtils
import com.prototypebuilder.domain.core.base.AppModel

class MainCompose {

    @Composable
    fun SetUpUI() {
        ComposeUtils.SetUpSystemUiColors()
        MainUI()
    }


    @Composable
    fun MainUI() {
        val viewModel: MainViewModel = viewModel()
        LazyColumn {

            viewModel.appsListState.value.forEach { appModel ->
                item {
                    AppItem(appModel, viewModel)
                }
            }

            item {
                AddNewAppLayout(viewModel)
            }
        }

    }

    @Composable
    private fun AddNewAppLayout(viewModel: MainViewModel) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                .clickable {
                }
        ) {
            val (appName) = createRefs()
            val isDialogOpen = remember { mutableStateOf(false) }

            Text(
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(appName) {
                        centerHorizontallyTo(parent)
                    },
                text = "Add New App"
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    isDialogOpen.value = true
                }
            )

            ShowAlertDialog(isDialogOpen, onBtnClick = {
                viewModel.insertApp(AppModel(it, 0))
            })

        }
    }

    @Composable
    fun AppItem(appModel: AppModel, viewModel: MainViewModel) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {

            val (number, logo, appName, activitiesCount, delete) = createRefs()

            Text(
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(number) {
                        start.linkTo(parent.start)
                        centerVerticallyTo(parent)
                    },
                text = appModel.appId.toString()
            )

            Image(
                painter = painterResource(id = R.drawable.ic_app_icon),
                contentDescription = "${appModel.appName} icon",
                modifier = Modifier.constrainAs(logo) {
                    start.linkTo(number.end, 10.dp)
                    centerVerticallyTo(parent)
                }
            )

            Text(
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(appName) {
                        centerVerticallyTo(parent)
                        start.linkTo(logo.end, 10.dp)
                    },
                text = appModel.appName
            )

            Image(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete ${appModel.appName}",
                modifier = Modifier
                    .constrainAs(delete) {
                        end.linkTo(parent.end, 10.dp)
                        centerVerticallyTo(parent)
                    }
                    .clickable {
                        viewModel.deleteApp(appModel.appId)
                    }
            )

        }
    }

}