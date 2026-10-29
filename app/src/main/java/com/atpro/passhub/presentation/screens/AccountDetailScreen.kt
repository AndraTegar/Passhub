package com.atpro.passhub.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.Shortcut
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atpro.passhub.R
import com.atpro.passhub.ui.theme.*

@Composable
fun AccountDetailScreen(
    onBackClick: () -> Unit = {},
    onEditClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CoklatBackground)
            // Menggunakan systemBarsPadding agar tidak menabrak status bar & nav bar
            .systemBarsPadding()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // 1. Ikon Kembali (Back Arrow)
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = PutihPure,
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 2. Header (Logo dan Nama Domain)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(PutihPure),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_logo), // Sesuaikan logo
                    contentDescription = "Logo",
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "accounts.google.com",
                color = PutihPure,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 3. Subtitle Link Domain
        Text(
            text = "accounts.google.com",
            color = PutihPure.copy(alpha = 0.8f),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 4. Kolom Email/Username
        DetailFieldCard(
            text = "Add password", // Mengikuti teks placeholder di desain Anda
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ContentCopy,
                    contentDescription = "Copy",
                    tint = PutihPure,
                    modifier = Modifier.size(20.dp)
                )
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 5. Kolom Password
        DetailFieldCard(
            text = "Add password",
            trailingIcon = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        contentDescription = "Show Password",
                        tint = PutihPure,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        imageVector = Icons.Outlined.ContentCopy,
                        contentDescription = "Copy Password",
                        tint = PutihPure,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 6. Kolom Catatan (Note)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CoklatGelap)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = "Add note",
                    color = PutihPure,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // 7. Tombol Aksi di Bawah (Share, Edit, Delete)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Ikon Bagikan / Panah Melengkung
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.Shortcut,
                contentDescription = "Share",
                tint = PutihPure,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* TODO: Aksi Share */ }
            )

            // Barisan Tombol Kanan
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                ActionPillButton(text = "Edit", onClick = onEditClick)
                ActionPillButton(text = "Delete", onClick = onDeleteClick)
            }
        }
    }
}

// === KOMPONEN UI REUSABLE (Dapat digunakan berulang kali) ===

@Composable
fun DetailFieldCard(
    text: String,
    trailingIcon: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CoklatGelap)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                color = PutihPure,
                fontSize = 16.sp
            )
            trailingIcon()
        }
    }
}

@Composable
fun ActionPillButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = CoklatLight),
        shape = RoundedCornerShape(50), // Membuat tombol berbentuk pil / bulat penuh di sisi
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = PutihPure,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}