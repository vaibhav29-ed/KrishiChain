package com.example.krishichain.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.krishichain.navigation.NavRoutes

@Composable
fun BatchHistoryScreen(navController: NavController) {
    // For demo, show static list
    val batches = listOf("FARM-OD-000001", "FARM-OD-000002")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Batch History", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        batches.forEach { batchId ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { navController.navigate("${NavRoutes.BatchDetail}/$batchId") }
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(batchId)
                }
            }
        }
    }
}