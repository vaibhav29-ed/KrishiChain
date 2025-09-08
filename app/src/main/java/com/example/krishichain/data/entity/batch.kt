package com.example.krishichain.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Batch(
    @PrimaryKey val id: String,
    val farmerId: String,
    val cropType: String,
    val variety: String,
    val quantityKg: Double,
    val harvestDate: Long,
    val lat: Double,
    val lon: Double,
    val photoUris: String, // JSON string
    val qualityReportUris: String, // JSON string
    val status: String,
    val historyEvents: String, // JSON string
    val synced: Boolean,
    val onChainTxId: String?
)