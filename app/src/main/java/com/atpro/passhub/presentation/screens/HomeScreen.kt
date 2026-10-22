package com.atpro.passhub.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atpro.passhub.R
import com.atpro.passhub.ui.theme.*

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CoklatBackground)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp)) // Jarak dari status bar atas

        // 1. Header: Shield Icon, Search Bar, Profile Image
        HeaderSection()

        Spacer(modifier = Modifier.height(24.dp))

        // 2. Daftar List Password yang bisa di-scroll
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // Item 1: Tombol Add Password
            item {
                AddPasswordCard(onClick = { /* TODO: Pindah ke Add Screen */ })
            }

            // Item 2 dst: List Akun Google (contoh data statis 5 buah)
            items(5) {
                AccountCard(
                    title = "accounts.google.com",
                    subtitle = "2 accounts"
                )
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Ikon Shield Kiri
        Icon(
            painter = painterResource(id = R.drawable.ic_shield_dark), // Ganti dengan nama ikon Anda
            contentDescription = "Security Status",
            tint = CoklatGelap,
            modifier = Modifier.size(32.dp)
        )

        // Kotak Pencarian (Search)
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .height(48.dp)
                .background(PutihColor, shape = CircleShape)
                .clickable { /* TODO: Aksi klik search */ }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = CoklatGelap
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Search", color = CoklatGelap.copy(alpha = 0.6f), fontSize = 16.sp)
        }

        // Avatar Profil Kanan
        Image(
            painter = painterResource(id = R.drawable.avatar_fox), // Ganti dengan gambar avatar rubah Anda
            contentDescription = "Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(CoklatGelap)
        )
    }
}

@Composable
fun AddPasswordCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CoklatGelap)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ikon Plus dengan bulatan warna CoklatLight
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(CoklatLight, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = PutihPure
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Add password",
                color = PutihPure,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun AccountCard(title: String, subtitle: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CoklatGelap)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Ikon Akun (Google Logo Bulat)
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(PutihPure, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google_logo), // Ganti dengan logo Google
                        contentDescription = "Google",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                // Teks Domain
                Text(
                    text = title,
                    color = PutihPure,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Teks Subtitle Kanan (misal: "2 accounts")
            Text(
                text = subtitle,
                color = PutihPure.copy(alpha = 0.7f),
                fontSize = 12.sp
            )
        }
    }
}