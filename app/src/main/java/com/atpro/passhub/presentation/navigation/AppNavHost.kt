package com.atpro.passhub.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atpro.passhub.presentation.screens.WelcomeScreen
import com.atpro.passhub.presentation.screens.NavigationScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        // Layar Pertama: WelcomeScreen
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onContinueClick = {
                    // Pindah ke rute Home yang berisi NavigationScreen
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

        // Layar Kedua: NavigationScreen (Navbar)
        // Pastikan parameter di sini sama dengan rute yang dipanggil di atas
        composable(Screen.Home.route) {
            NavigationScreen()
        }
    }
}