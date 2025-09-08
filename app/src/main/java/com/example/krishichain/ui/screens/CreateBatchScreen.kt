package com.example.krishichain.ui.screens

import android.Manifest
import android.app.DatePickerDialog
import android.content.Context
import android.location.Location
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.krishichain.navigation.NavRoutes
import java.util.*

@Composable
fun CreateBatchScreen(navController: NavController) {
    val context = LocalContext.current
    var cropType by remember { mutableStateOf("") }
    var variety by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var harvestDate by remember { mutableStateOf("") }
    var lat by remember { mutableStateOf("") }
    var lon by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Create Batch", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = cropType,
            onValueChange = { cropType = it },
            label = { Text("Crop Type") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = variety,
            onValueChange = { variety = it },
            label = { Text("Variety") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = harvestDate,
            onValueChange = { harvestDate = it },
            label = { Text("Harvest Date") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = {
                    val calendar = Calendar.getInstance()
                    DatePickerDialog(
                        context,
                        { _: DatePicker, year: Int, month: Int, day: Int ->
                            harvestDate = "$day/${month + 1}/$year"
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }) {
                    Icon(painterResource(id = android.R.drawable.ic_menu_my_calendar), contentDescription = null)
                }
            }
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = lat,
            onValueChange = { lat = it },
            label = { Text("Latitude") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = lon,
            onValueChange = { lon = it },
            label = { Text("Longitude") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                // TODO: Implement image picker
                imageUri = null
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pick Image")
        }
        imageUri?.let {
            AsyncImage(model = it, contentDescription = null, modifier = Modifier.size(96.dp))
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (cropType.isBlank() || variety.isBlank() || quantity.isBlank() || harvestDate.isBlank()) {
                    error = "Please fill all fields"
                } else {
                    // Save batch to DB, generate QR, navigate to BatchDetail
                    navController.navigate(NavRoutes.BatchHistory)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Batch")
        }
        if (error.isNotBlank()) {
            Spacer(Modifier.height(8.dp))
            Text(error, color = MaterialTheme.colorScheme.error)
        }
    }
}