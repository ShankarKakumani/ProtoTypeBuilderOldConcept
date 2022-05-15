/**
 * Author : Mani Shankar Kakumani,
 * Created on : 03 May, 2022.
 */

package com.prototypebuilder.app.compose.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.prototypebuilder.app.compose.values.getAppColors
import com.prototypebuilder.app.compose.values.getAppIcons

@Composable
fun CustomToolbar(
    modifier: Modifier = Modifier,
    title: String,
    onActionIconClick: () -> Unit = {},
    actionIcon: Int = getAppIcons().backArrowBlackBox,
    actionIconTint: Color = getAppColors().mainTextColor,

    ) {
    ConstraintLayout(modifier = modifier
        .fillMaxWidth()
        .background(color = Color.White)
    ) {
        val (backArrow, headerText) = createRefs()

        IconButton(
            onClick = {
                onActionIconClick.invoke()
            },
            modifier = Modifier
                .constrainAs(backArrow) {
                    start.linkTo(parent.start, 10.dp)
                    top.linkTo(parent.top, 10.dp)
                }
        ) {
            Icon(
                painterResource(id = actionIcon),
                null,
                tint = actionIconTint
            )
        }

        Text(
            title,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = getAppColors().mainTextColor,
            modifier = Modifier.constrainAs(headerText) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top, 20.dp)
                centerHorizontallyTo(parent)
            }
        )

    }
}