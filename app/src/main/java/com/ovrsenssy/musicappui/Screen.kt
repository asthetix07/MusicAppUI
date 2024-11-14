package com.ovrsenssy.musicappui

import androidx.annotation.DrawableRes

sealed class Screen( val title: String, val route: String ) {

    sealed class DrawerScreen( val dtitle: String,
                               val droute: String,
                               @DrawableRes val icon: Int): Screen(dtitle, droute)
    {
        object Account: DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_manage_accounts_24
        )

        object Subscription: DrawerScreen(
            "Subscription",
            "subscription",
            R.drawable.baseline_library_music_24
        )

        object AddAccount: DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.baseline_person_add_alt_1_24
        )
    }
}

val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount
)