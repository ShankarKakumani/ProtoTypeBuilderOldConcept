package com.prototypebuilder.app.compose.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.prototypebuilder.app.R
import com.prototypebuilder.app.compose.values.BluePrimary

@Composable
fun ShowAlertDialog(
    isDialogOpen: MutableState<Boolean>,
    onBtnClick: (value: String) -> Unit,
) {
    val emailVal = remember { mutableStateOf("") }


    if (isDialogOpen.value) {
        Dialog(onDismissRequest = { isDialogOpen.value = false }) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .wrapContentHeight()
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Add new App",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.padding(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_app_icon),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    OutlinedTextField(
                        value = emailVal.value,
                        onValueChange = { emailVal.value = it },
                        label = { Text(text = "App Name") },
                        placeholder = { Text(text = "Enter App Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = BluePrimary,
                            focusedLabelColor = BluePrimary,
                            textColor = BluePrimary,)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Button(
                        onClick = {
                            isDialogOpen.value = false
                            onBtnClick.invoke(emailVal.value)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(BluePrimary)
                    ) {
                        Text(
                            text = "Create",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }

}