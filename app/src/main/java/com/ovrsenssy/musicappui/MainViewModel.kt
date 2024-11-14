package com.ovrsenssy.musicappui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val baseScreen: MutableState<Screen> = mutableStateOf(Screen.DrawerScreen.AddAccount)

    val currentScreen: MutableState<Screen>
        get() = baseScreen

    fun setCurrentScreen(screen: Screen){
        baseScreen.value = screen
    }

}