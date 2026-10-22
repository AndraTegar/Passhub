package com.atpro.passhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.atpro.passhub.ui.theme.PasshubTheme
import com.atpro.passhub.presentation.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasshubTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost() // Panggil AppNavHost di sini
                }
            }
        }
    }
}