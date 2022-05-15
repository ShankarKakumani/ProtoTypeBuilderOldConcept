/**
 * Author : Mani Shankar Kakumani,
 * Created on : 14 May, 2022.
 */

package com.prototypebuilder.app.views.appInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prototypebuilder.app.R
import com.prototypebuilder.app.compose.layouts.CustomButton
import com.prototypebuilder.app.compose.layouts.CustomToolbar
import com.prototypebuilder.app.utils.ComposeUtils

class AppInfoCompose {

    @Composable
    fun SetUpUI() {
        ComposeUtils.SetUpSystemUiColors()
        AppInfoContent()
    }

    @Composable
    private fun AppInfoContent() {
        val viewModel: AppInfoViewModel = viewModel()
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
        ) {

            val (toolbar, appDetails, divider, activitiesList) = createRefs()


            CustomToolbar(title = "App Info",
                modifier = Modifier.constrainAs(toolbar) {
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top)
                },
                onActionIconClick = {
                    viewModel.navigator?.onBackPressed()
                }
            )

            AppDetails(modifier = Modifier.constrainAs(appDetails) {
                top.linkTo(toolbar.bottom, 20.dp)
            }, viewModel)

            Divider(modifier = Modifier
                .constrainAs(divider)
                {
                    top.linkTo(appDetails.bottom, 8.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    width = Dimension.fillToConstraints
                }
            )


            ActivitiesList(
                modifier = Modifier.constrainAs(activitiesList) {
                    top.linkTo(divider.bottom, 15.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }

    @Composable
    private fun ActivitiesList(modifier: Modifier) {

        ConstraintLayout(modifier = modifier) {
            val (activitiesList, title) = createRefs()

            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(parent.start, 20.dp)
                        top.linkTo(parent.top, 20.dp)
                    },
                fontSize = 20.sp,
                color = Color.Black,
                text = "Screens"
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .height(20.dp)
                    .constrainAs(activitiesList) {
                    },
                columns = GridCells.Fixed(3)
            ) {


            }

        }

    }

    @Composable
    private fun AppDetails(modifier: Modifier, viewModel: AppInfoViewModel) {
        ConstraintLayout(
            modifier = modifier.fillMaxWidth()
        ) {

            val appDetails = viewModel.appByIdState.value
            val title = appDetails?.appName ?: "APP_NAME_NOT_FOUND"

            val (appLogo, appName, editButton) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.ic_app_icon),
                contentDescription = "$title icon",
                modifier = Modifier
                    .constrainAs(appLogo) {
                        start.linkTo(parent.start, 25.dp)
                    }
                    .size(50.dp)
            )


            Text(
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(appName) {
                        start.linkTo(appLogo.end, 10.dp)
                        centerVerticallyTo(appLogo)
                    },
                fontSize = 20.sp,
                color = Color.Black,
                text = title
            )


            CustomButton(
                modifier = Modifier.constrainAs(editButton) {
                    top.linkTo(appLogo.bottom, 15.dp)
                    start.linkTo(appLogo.start)
                },
                text = "Edit"
            )


        }
    }

}