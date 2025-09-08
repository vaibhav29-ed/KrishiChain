package com.example.krishichain.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.krishichain.navigation.NavRoutes
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import org.json.JSONObject

@Composable
fun BatchDetailScreen(navController: NavController, batchId: String) {
    // For demo, generate QR from batchId
    val qrBitmap = remember(batchId) {
        val size = 256
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(
            JSONObject(mapOf("id" to batchId, "timestamp" to System.currentTimeMillis())).toString(),
            BarcodeFormat.QR_CODE, size, size
        )
        val bmp = android.graphics.Bitmap.createBitmap(size, size, android.graphics.Bitmap.Config.RGB_565)
        for (x in 0 until size) {
            for (y in 0 until size) {
                bmp.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
            }
        }
        bmp
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Batch Details", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text("Batch ID: $batchId")
        Spacer(Modifier.height(16.dp))
        Image(bitmap = qrBitmap.asImageBitmap(), contentDescription = "QR Code", modifier = Modifier.size(256.dp))
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Save/Share QR */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save/Share QR")
        }
    }
}