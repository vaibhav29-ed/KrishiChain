package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.krishichain.navigation.NavRoutes

@Composable
fun DistributorDashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Distributor Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(NavRoutes.QRScanner) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Scan Batch QR")
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(NavRoutes.BatchHistory) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Batch History")
        }
    }
}