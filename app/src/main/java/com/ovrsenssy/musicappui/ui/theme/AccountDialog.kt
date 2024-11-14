package com.ovrsenssy.musicappui.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.primarySurface
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.ovrsenssy.musicappui.R

@Composable
fun AccountDialog(dialogOpen: MutableState<Boolean>){

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    if(dialogOpen.value){
        AlertDialog(onDismissRequest = {
            dialogOpen.value = false
        },
        confirmButton = {
            TextButton(onClick = {
                dialogOpen.value = false
            }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                dialogOpen.value = false
            }) {
                Text("Dismiss")
            }
        },
        title = {
            Text("Add account")
        },
        text = {
            Column(modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(value = "", onValueChange = { email.value = it}, label = { Text("Email") }, shape = RoundedCornerShape(5) )
                Spacer(Modifier.padding(5.dp))
                OutlinedTextField(value = "", onValueChange = { password.value = it}, label = { Text("Password") }, shape = RoundedCornerShape(5) )
            }
        },
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.primarySurface).padding(8.dp),

        shape = RoundedCornerShape(10),

        backgroundColor = colorResource(id = R.color.l_green),

        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
        )
    }
}