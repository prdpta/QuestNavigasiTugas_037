package com.example.questnavigasitugas_037.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListData(
    dataList: List<List<String>>,
    OnBerandaClick: () -> Unit,
    OnFormulirClick: () -> Unit
) {
    Scaffold(
        containerColor = Color(0xFFFFF7E6), // warna krem lembut
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedButton(
                    onClick = OnBerandaClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Beranda")
                }

                OutlinedButton(
                    onClick = OnFormulirClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Formulir")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Daftar Pesanan Kopi",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E342E)
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (dataList.isEmpty()) {
                Text("Belum ada pesanan.", color = Color.Gray)
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(dataList) { data ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            "NAMA PEMESAN",
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF795548),
                                            fontSize = 12.sp
                                        )
                                        Text(data[0], fontSize = 14.sp, color = Color.Black)
                                    }

                                    Column(horizontalAlignment = Alignment.End) {
                                        Text(
                                            "JENIS KOPI",
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF795548),
                                            fontSize = 12.sp
                                        )
                                        Text(data[1], fontSize = 14.sp, color = Color.Black)
                                    }
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            "UKURAN CUP",
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF795548),
                                            fontSize = 12.sp
                                        )
                                        Text(data[2], fontSize = 14.sp, color = Color.Black)
                                    }

                                    Column(horizontalAlignment = Alignment.End) {
                                        Text(
                                            "PEMBAYARAN",
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF795548),
                                            fontSize = 12.sp
                                        )
                                        Text(data[3], fontSize = 14.sp, color = Color.Black)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
