package com.atpro.passhub.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atpro.passhub.R
import com.atpro.passhub.ui.theme.*

@Composable
fun NavigationScreen(
    onAddPasswordClick: () -> Unit = {},
    onAccountClick: () -> Unit = {}
) {
    Scaffold(
        bottomBar = { PasshubBottomNavigationBar() },
        containerColor = CoklatBackground
    ) { innerPadding ->
        // Teruskan fungsi klik ke HomeScreen
        HomeScreen(
            modifier = Modifier.padding(innerPadding),
            onAddPasswordClick = onAddPasswordClick,
            onAccountClick = onAccountClick
        )
    }
}

@Composable
fun PasshubBottomNavigationBar() {
    // Anda bisa mengganti nilai ini nanti jika menggunakan NavController sungguhan
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Accounts", "Checkup", "Settings")

    NavigationBar(
        containerColor = PutihPure,
        contentColor = CoklatGelap,
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = when (index) {
                                0 -> R.drawable.ic_lock
                                1 -> R.drawable.ic_key
                                else -> R.drawable.ic_settings
                            }
                        ),
                        contentDescription = item,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    if (selectedItem == index) {
                        Text(text = item, color = CoklatLight)
                    }
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = CoklatLight,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = PutihPure
                )
            )
        }
    }
}