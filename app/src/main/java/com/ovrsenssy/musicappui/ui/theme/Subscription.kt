package com.ovrsenssy.musicappui.ui.theme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Subscription(){

    Column(modifier = Modifier.height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Manage Subscription")

        Card(modifier = Modifier.padding(8.dp), elevation = 6.dp)
        {
            Column(modifier = Modifier.padding(8.dp))
            {
                Column()
                {
                    Text("Trial")
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Text("trail")
                        TextButton(onClick = {})
                        {
                            Row()
                            {
                                Text("See all plan")

                                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Plan")
                            }
                        }
                    }
                }
                Divider(thickness = 4.dp, modifier = Modifier.padding(horizontal = 8.dp))

                Row(Modifier.padding(vertical = 16.dp))
                {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Get plan")
                    Spacer(Modifier.padding(3.dp))
                    Text("Get a plan")
                }
            }
        }
    }
}