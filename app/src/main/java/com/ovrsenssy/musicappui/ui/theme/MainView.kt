package com.ovrsenssy.musicappui.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ovrsenssy.musicappui.MainViewModel
import com.ovrsenssy.musicappui.Navigation
import com.ovrsenssy.musicappui.R
import com.ovrsenssy.musicappui.Screen
import com.ovrsenssy.musicappui.screensInDrawer
import com.ovrsenssy.musicappui.ui.theme.AccountDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@Composable
fun MainView() {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val viewModel: MainViewModel = viewModel()
    val title = remember { mutableStateOf(viewModel.currentScreen.value.title) }

    val dialogOpen = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title.value, modifier = Modifier.padding(top = 20.dp)) // Shift text down
                },
                backgroundColor = colorResource(id = R.color.l_green),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp), // Set custom TopAppBar height
                    navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "main drawer",
                            modifier = Modifier.padding(top = 20.dp) // Shift icon down
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp)) {
                items(screensInDrawer) { item ->
                    DrawerItem(used = currentRoute == item.droute, item = item) {
                        scope.launch { scaffoldState.drawerState.close() }
                        if (item.droute != "add_account") {
                            dialogOpen.value = true
                        }
                        else{
                            controller.navigate(item.droute)
                            title.value = item.dtitle
                        }
                    }
                }
            }
        }
    ) {

        Navigation(navController = controller, viewModel = viewModel, pd = it)

        AccountDialog(dialogOpen = dialogOpen)
    }
}

@Composable
fun DrawerItem(used: Boolean, item: Screen.DrawerScreen, itemClicked: () -> Unit) {

    val background = if (used) Color.DarkGray else Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .clickable { itemClicked() }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dtitle,
            modifier = Modifier.padding(top = 4.dp, end = 8.dp)
        )
        Text(text = item.dtitle, style = MaterialTheme.typography.h5)
    }
}
