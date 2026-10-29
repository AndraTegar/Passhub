package com.atpro.passhub.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atpro.passhub.presentation.screens.*

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

        // Layar Utama (Navbar + HomeScreen)
        composable(Screen.Home.route) {
            NavigationScreen(
                onAddPasswordClick = {
                    // Berpindah ke AddPasswordScreen
                    navController.navigate(Screen.AddPassword.route)
                },
                onAccountClick = {
                    // Berpindah ke AccountDetailScreen (Edit Password)
                    navController.navigate(Screen.AccountDetail.route)
                }
            )
        }

        // Layar Tambah Password
        composable(Screen.AddPassword.route) {
            AddPasswordScreen(
                onCloseClick = { navController.popBackStack() }, // Kembali ke Home
                onSaveClick = { navController.popBackStack() }   // Simpan & Kembali ke Home
            )
        }

        // Layar Detail / Edit Password
        composable(Screen.AccountDetail.route) {
            AccountDetailScreen(
                onBackClick = { navController.popBackStack() } // Kembali ke Home
            )
        }
    }
}