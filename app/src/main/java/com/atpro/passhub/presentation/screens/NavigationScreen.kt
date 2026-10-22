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
fun NavigationScreen() {
    // Scaffold bertindak sebagai kerangka layar yang memiliki Bottom Bar
    Scaffold(
        bottomBar = { PasshubBottomNavigationBar() },
        containerColor = CoklatBackground // Warna latar belakang utama
    ) { innerPadding ->
        // HomeScreen dipanggil di sini dan diberi padding agar tidak tertutup navbar
        HomeScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun PasshubBottomNavigationBar() {
    // Anda bisa mengganti nilai ini nanti jika menggunakan NavController sungguhan
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Accounts", "Generator", "Settings")

    NavigationBar(
        containerColor = PutihPure,
        contentColor = CoklatGelap,
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    // Gunakan ikon bawaan Material sementara jika Anda belum punya file drawable-nya
                    Icon(
                        painter = painterResource(
                            id = when (index) {
                                0 -> R.drawable.ic_shield_account // Ganti dengan ikon shield Anda
                                1 -> R.drawable.ic_document       // Ganti dengan ikon dokumen Anda
                                else -> R.drawable.ic_settings    // Ganti dengan ikon gear/settings Anda
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
                    indicatorColor = PutihPure // Menghilangkan background bulat bawaan Material3
                )
            )
        }
    }
}