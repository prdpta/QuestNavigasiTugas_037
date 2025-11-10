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
