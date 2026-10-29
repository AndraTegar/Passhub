package com.atpro.passhub.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atpro.passhub.ui.theme.*

@Composable
fun AddPasswordScreen(
    onCloseClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {
    // State untuk menyimpan teks yang diketik pengguna
    var siteText by remember { mutableStateOf("") }
    var usernameText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var noteText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CoklatBackground) // Latar belakang utama
            .systemBarsPadding() // Menghindari area status bar & navigation bar
    ) {
        // 1. App Bar Atas (Icon Close, Judul, Tombol Save)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = PutihPure,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onCloseClick() }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Add password",
                color = PutihPure,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Save",
                color = PutihPure.copy(alpha = 0.9f),
                fontSize = 16.sp,
                modifier = Modifier.clickable { onSaveClick() }
            )
        }

        // Konten Form yang bisa di-scroll jika layarnya kecil
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            // --- SECTION 1: Site or App ---
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Site or app", // Teks label[cite: 5]
                    color = PutihPure.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Input Form Site[cite: 5]
                PasshubTextField(
                    value = siteText,
                    onValueChange = { siteText = it },
                    placeholder = "Site"
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Pill Select App[cite: 5]
                PasshubActionPill(
                    text = "Select app",
                    icon = Icons.Outlined.AddCircleOutline,
                    onClick = { /* TODO */ }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Garis Pemisah (Divider) horizontal[cite: 5]
            HorizontalDivider(
                color = CoklatLight.copy(alpha = 0.5f),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // --- SECTION 2: Credentials & Note ---
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    text = "Make sure youre", // Teks label (sesuai gambar desain Anda)[cite: 5]
                    color = PutihPure.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Input Form Username / Email[cite: 5]
                PasshubTextField(
                    value = usernameText,
                    onValueChange = { usernameText = it },
                    placeholder = "Add password" // (Teks aslinya di desain tertulis Add password)
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Input Form Password dengan Ikon Mata[cite: 5]
                PasshubTextField(
                    value = passwordText,
                    onValueChange = { passwordText = it },
                    placeholder = "Add password",
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Visibility,
                            contentDescription = "Show Password",
                            tint = PutihPure,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Pill Suggest Strong Password[cite: 5]
                PasshubActionPill(
                    text = "Suggest strong password",
                    icon = Icons.Outlined.Key,
                    onClick = { /* TODO */ }
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Input Form Catatan (Note)[cite: 5]
                PasshubTextField(
                    value = noteText,
                    onValueChange = { noteText = it },
                    placeholder = "Add note",
                    height = 100.dp,
                    singleLine = false // Mengizinkan multi-baris (enter)
                )

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}


// === KOMPONEN UI CUSTOM ===

@Composable
fun PasshubTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    height: Dp = 64.dp
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, color = PutihPure.copy(alpha = 0.7f)) },
        modifier = modifier
            .fillMaxWidth()
            .height(height), // Menentukan tinggi kotak agar mirip Card desain Anda
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = CoklatGelap, // Warna kotak input[cite: 5]
            unfocusedContainerColor = CoklatGelap,
            focusedTextColor = PutihPure,
            unfocusedTextColor = PutihPure,
            cursorColor = PutihPure,
            // Menghilangkan garis bawah bawaan TextField Material
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = trailingIcon,
        singleLine = singleLine
    )
}

@Composable
fun PasshubActionPill(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable { onClick() },
        shape = RoundedCornerShape(50), // Bentuk pil[cite: 5]
        color = CoklatGelap // Warna latar belakang pil[cite: 5]
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = PutihPure,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = PutihPure,
                fontSize = 14.sp
            )
        }
    }
}