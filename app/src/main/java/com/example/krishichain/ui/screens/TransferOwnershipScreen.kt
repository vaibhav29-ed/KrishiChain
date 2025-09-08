package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TransferOwnershipScreen(navController: NavController) {
    var selectedRetailer by remember { mutableStateOf("") }
    val retailers = listOf("RETL-OD-000001", "RETL-OD-000002")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Transfer Ownership", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        retailers.forEach { retailer ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedRetailer == retailer,
                    onClick = { selectedRetailer = retailer }
                )
                Text(retailer)
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                // TODO: Record transfer event
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Transfer")
        }
    }
}