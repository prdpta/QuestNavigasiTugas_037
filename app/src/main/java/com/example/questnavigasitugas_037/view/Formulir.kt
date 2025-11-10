package com.example.questnavigasitugas_037.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    dataList: MutableList<List<String>>,
    OnSubmitBtnClick: () -> Unit,
    OnBackBtnClick: () -> Unit = {}
) {
    // ===== Variabel input =====
    var namaPelanggan by remember { mutableStateOf("") }
    var jenisKopi by remember { mutableStateOf("") }
    var ukuranCangkir by remember { mutableStateOf("") }
    var catatanTambahan by remember { mutableStateOf("") }

    val jenisKopiList = listOf("Espresso", "Latte", "Cappuccino", "Americano", "Mocca")
    val ukuranList = listOf("Small", "Medium", "Large")

    var expandedKopi by remember { mutableStateOf(false) }
    var expandedUkuran by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showWarning by remember { mutableStateOf(false) }

    // ===== Tampilan utama =====
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFFFF8E1) // warna krem kopi
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Formulir Pemesanan Kopi",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E342E)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Card Formulir
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Nama Pelanggan
                    Text("NAMA PELANGGAN", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    OutlinedTextField(
                        value = namaPelanggan,
                        onValueChange = { namaPelanggan = it },
                        placeholder = { Text("Masukkan nama pelanggan") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Jenis Kopi
                    Text("JENIS KOPI", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    ExposedDropdownMenuBox(
                        expanded = expandedKopi,
                        onExpandedChange = { expandedKopi = !expandedKopi }
                    ) {
                        OutlinedTextField(
                            value = jenisKopi,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = { Text("Pilih jenis kopi") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedKopi)
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = expandedKopi,
                            onDismissRequest = { expandedKopi = false }
                        ) {
                            jenisKopiList.forEach { kopi ->
                                DropdownMenuItem(
                                    text = { Text(kopi) },
                                    onClick = {
                                        jenisKopi = kopi
                                        expandedKopi = false
                                    }
                                )
                            }
                        }
                    }

                    // Ukuran Cangkir
                    Text("UKURAN CANGKIR", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    ExposedDropdownMenuBox(
                        expanded = expandedUkuran,
                        onExpandedChange = { expandedUkuran = !expandedUkuran }
                    ) {
                        OutlinedTextField(
                            value = ukuranCangkir,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = { Text("Pilih ukuran") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedUkuran)
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = expandedUkuran,
                            onDismissRequest = { expandedUkuran = false }
                        ) {
                            ukuranList.forEach { size ->
                                DropdownMenuItem(
                                    text = { Text(size) },
                                    onClick = {
                                        ukuranCangkir = size
                                        expandedUkuran = false
                                    }
                                )
                            }
                        }
                    }

                    // Catatan Tambahan
                    Text("CATATAN TAMBAHAN", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    OutlinedTextField(
                        value = catatanTambahan,
                        onValueChange = { catatanTambahan = it },
                        placeholder = { Text("Contoh: tanpa gula, extra shot...") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Tombol Aksi
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        OutlinedButton(
                            onClick = OnBackBtnClick,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Kembali")
                        }

                        Button(
                            onClick = {
                                if (namaPelanggan.isBlank() || jenisKopi.isBlank() || ukuranCangkir.isBlank()) {
                                    showWarning = true
                                } else {
                                    dataList.add(listOf(namaPelanggan, jenisKopi, ukuranCangkir, catatanTambahan))
                                    showDialog = true
                                }
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF795548))
                        ) {
                            Text("Pesan", color = Color.White)
                        }
                    }
                }
            }
        }

        // ===== Dialog Berhasil =====
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                containerColor = Color(0xFF795548),
                title = {
                    Text(
                        text = "Pesanan Berhasil!",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Column {
                        Text("Nama: $namaPelanggan", color = Color.White)
                        Text("Kopi: $jenisKopi", color = Color.White)
                        Text("Ukuran: $ukuranCangkir", color = Color.White)
                        if (catatanTambahan.isNotBlank())
                            Text("Catatan: $catatanTambahan", color = Color.White)
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            OnSubmitBtnClick()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("OK", color = Color(0xFF795548))
                    }
                }
            )
        }

