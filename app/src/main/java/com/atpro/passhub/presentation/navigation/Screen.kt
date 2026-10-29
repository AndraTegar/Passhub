package com.atpro.passhub.presentation.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("WelcomeScreen")
    object Home : Screen("HomeScreen") // Ini adalah NavigationScreen yang membungkus HomeScreen
    object AddPassword : Screen("AddPasswordScreen")
    object AccountDetail : Screen("AccountDetailScreen")
}