package com.example.questnavigasitugas_037

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_037.view.Formulir
import com.example.questnavigasitugas_037.view.Home
import com.example.questnavigasitugas_037.view.ListData

enum class Navigasi {
    Home,
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
// Data global antar halaman
    val dataList = remember { mutableStateListOf<List<String>>() }

