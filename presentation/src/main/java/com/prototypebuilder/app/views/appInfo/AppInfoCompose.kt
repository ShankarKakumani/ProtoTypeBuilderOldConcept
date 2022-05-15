/**
 * Author : Mani Shankar Kakumani,
 * Created on : 14 May, 2022.
 */

package com.prototypebuilder.app.views.appInfo

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prototypebuilder.app.R
import com.prototypebuilder.app.compose.layouts.CustomButton
import com.prototypebuilder.app.compose.layouts.CustomToolbar
import com.prototypebuilder.app.compose.values.getAppColors
import com.prototypebuilder.app.utils.ComposeUtils
import com.prototypebuilder.domain.core.base.ActivityModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
class AppInfoCompose {

    @Composable
    fun SetUpUI() {
        ComposeUtils.SetUpSystemUiColors()
        BottomSheetSetup()
    }

    @Composable
    private fun BottomSheetSetup() {
        val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val viewModel: AppInfoViewModel = viewModel()
        val scope = rememberCoroutineScope()

        ModalBottomSheetLayout(
            sheetContent = {
                BottomSheetContent()
            },
            sheetState = sheetState, sheetBackgroundColor = Color.White,
            content = {
                AppInfoContent(viewModel = viewModel) {
                    scope.launch {
                        sheetState.show()
                    }
                }
            },
        )
    }

    @Composable
    private fun BottomSheetContent() {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Bottom Sheet",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Item 1",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Item 2",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Item 3",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }

    @Composable
    private fun AppInfoContent(
        viewModel: AppInfoViewModel, showBottomSheet: (show: Boolean) -> Unit = {}
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color.White)
        ) {

            val (toolbar, appDetails, divider, activitiesList) = createRefs()


            CustomToolbar(
                title = "App Info",
                modifier = Modifier.constrainAs(toolbar) {
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top)
                },
                onActionIconClick = {
                    viewModel.navigator?.onBackPressed()
                },
            )

            AppDetails(
                modifier = Modifier.constrainAs(appDetails) {
                    top.linkTo(toolbar.bottom, 20.dp)
                }, viewModel = viewModel
            )

            Divider(
                modifier = Modifier.constrainAs(divider) {
                    top.linkTo(appDetails.bottom, 8.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    width = Dimension.fillToConstraints
                },
            )

            ActivitiesList(
                modifier = Modifier.constrainAs(activitiesList) {
                    top.linkTo(divider.bottom, 15.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                viewModel = viewModel,
                showBottomSheet = showBottomSheet,
            )
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

            Image(painter = painterResource(id = R.drawable.ic_app_icon),
                contentDescription = "$title icon",
                modifier = Modifier
                    .constrainAs(appLogo) {
                        start.linkTo(parent.start, 25.dp)
                    }
                    .size(50.dp))


            Text(
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(appName) {
                        start.linkTo(appLogo.end, 10.dp)
                        centerVerticallyTo(appLogo)
                    }, fontSize = 20.sp, color = Color.Black, text = title
            )


            CustomButton(
                modifier = Modifier.constrainAs(editButton) {
                    top.linkTo(appLogo.bottom, 15.dp)
                    start.linkTo(appLogo.start)
                }, text = "Edit"
            )
        }
    }

    @Composable
    private fun ActivitiesList(
        modifier: Modifier, viewModel: AppInfoViewModel, showBottomSheet: (show: Boolean) -> Unit
    ) {

        ConstraintLayout(modifier = modifier) {
            val (activitiesList, title) = createRefs()

            Text(
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(parent.start, 20.dp)
                    top.linkTo(parent.top, 20.dp)
                }, fontSize = 20.sp, color = Color.Black, text = "Screens"
            )

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp)
                    .constrainAs(activitiesList) {
                        top.linkTo(title.bottom, 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
            ) {

                viewModel.activityListState.value.forEachIndexed { index, activityModel ->

                    ActivityItem(activityModel)


                }

                AddNewActivityItem(viewModel, showBottomSheet)

            }

        }

    }

    @Composable
    private fun AddNewActivityItem(
        viewModel: AppInfoViewModel, showBottomSheet: (show: Boolean) -> Unit
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(1.dp, color = getAppColors().bluePrimary)
                .clickable {
                    showBottomSheet.invoke(true)
                },
        ) {
            val (text) = createRefs()
            Text(text = "Add new Activity", modifier = Modifier.constrainAs(text) {
                centerTo(parent)
            })
        }

    }


    @Composable
    private fun ActivityItem(activityModel: ActivityModel) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Text(text = activityModel.activityName ?: return)
        }
    }
}