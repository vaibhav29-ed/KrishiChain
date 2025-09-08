package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.krishichain.navigation.NavRoutes

@Composable
fun ConsumerDashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Consumer Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(NavRoutes.QRScanner) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Scan Batch QR")
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(NavRoutes.Feedback) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit Feedback")
        }
    }
}