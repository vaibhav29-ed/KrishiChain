package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun UpdatePriceScreen(navController: NavController) {
    var price by remember { mutableStateOf("") }
    var sold by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Update Price / Mark Sold", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Sale Price") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                sold = true
                // TODO: Save to DB and send mock API update
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mark Sold")
        }
        if (sold) {
            Spacer(Modifier.height(16.dp))
            Text("Batch marked as sold at ₹$price")
        }
    }
}