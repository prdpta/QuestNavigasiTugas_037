package com.example.questnavigasitugas_037.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_037.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    OnMasukBtnClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFF8E1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(70.dp))

            // Teks Selamat Datang
            Text(
                text = "SELAMAT DATANG DI",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF5D4037),
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Logo Kopi
            Image(
                painter = painterResource(id = R.drawable.kopi), // pastikan logo kopi ada di drawable
                contentDescription = "Logo KopiKu",
                modifier = Modifier.size(220.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Nama Aplikasi
            Text(
                text = "☕ KopiKu",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF3E2723),
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Teman Ngopimu Setiap Hari",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF6D4C41),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(145.dp))

        // Nama dan NIM
            Text(
                text = "Pradipta Pratama Putra",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF4E342E),
                textAlign = TextAlign.Center
            )

            Text(
                text = "20230140037",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF4E342E),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))

