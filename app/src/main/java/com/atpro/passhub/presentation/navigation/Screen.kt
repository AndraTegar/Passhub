package com.atpro.passhub.presentation.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("WelcomeScreen")
    object Home : Screen("HomeScreen")
}