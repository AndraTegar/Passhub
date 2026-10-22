package com.atpro.passhub.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atpro.passhub.presentation.components.WavyShape
import com.atpro.passhub.R
import androidx.compose.foundation.layout.navigationBarsPadding

// 1. Import warna-warna dari Color.kt kamu di sini
import com.atpro.passhub.ui.theme.CoklatBackground
import com.atpro.passhub.ui.theme.CoklatGelap
import com.atpro.passhub.ui.theme.CoklatLight
import com.atpro.passhub.ui.theme.PutihColor
import com.atpro.passhub.ui.theme.PutihPure

@Composable
fun WelcomeScreen(onContinueClick: () -> Unit = {}) {
    val welcomeMessages = listOf(
        "Simpan semua kata sandimu dengan aman dalam satu tempat.",
        "Keamanan tingkat tinggi untuk melindungi data privasi digitalmu.",
        "Tidak perlu lagi mengingat banyak password, biarkan Passhub yang mengingatnya.",
        "Kelola akses akunmu dengan enkripsi terbaik secara praktis."
    )

    val randomMessage = remember { welcomeMessages.random() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            // 2. Gunakan PutihColor untuk background (putih sedikit krem)
            .background(PutihColor)
    ) {

        Image(
            painter = painterResource(id = R.drawable.texture_bg),
            contentDescription = "Background Topography",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(WavyShape())
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .padding(horizontal = 32.dp, vertical = 43.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = "Welcome",
                // 3. Gunakan CoklatGelap untuk judul agar terlihat tegas
                color = CoklatGelap,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = randomMessage,
                // 4. Gunakan CoklatLight untuk teks deskripsi
                color = CoklatLight,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(bottom = 64.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onContinueClick,
                    modifier = Modifier
                        .size(48.dp)
                        // 5. Gunakan CoklatBackground untuk warna tombol lingkaran
                        .background(color = CoklatBackground, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_forward),
                        contentDescription = "Continue",
                        // 6. Gunakan PutihPure agar ikon panah terlihat terang
                        tint = PutihPure
                    )
                }
            }
        }
    }
}