package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun QRScannerScreen(navController: NavController) {
    // For emulator fallback, allow manual entry
    var qrString by remember { mutableStateOf("") }
    var scanned by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("QR Scanner", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = qrString,
            onValueChange = { qrString = it },
            label = { Text("Paste QR String (emulator fallback)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                scanned = true
                // TODO: Decode QR and fetch batch details
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Scan")
        }
        if (scanned) {
            Spacer(Modifier.height(16.dp))
            Text("Scanned: $qrString")
        }
    }
}