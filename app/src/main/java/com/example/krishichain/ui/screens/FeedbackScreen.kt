package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FeedbackScreen(navController: NavController) {
    var rating by remember { mutableStateOf(0f) }
    var feedback by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Submit Feedback", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Slider(
            value = rating,
            onValueChange = { rating = it },
            valueRange = 0f..5f,
            steps = 4,
            modifier = Modifier.fillMaxWidth()
        )
        Text("Rating: ${rating.toInt()}/5")
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = feedback,
            onValueChange = { feedback = it },
            label = { Text("Feedback") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                submitted = true
                // TODO: Save feedback locally
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
        if (submitted) {
            Spacer(Modifier.height(16.dp))
            Text("Thank you for your feedback!")
        }
    }
}