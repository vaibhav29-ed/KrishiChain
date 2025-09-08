package com.example.krishichain.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserProfile(
    @PrimaryKey val id: String,
    val role: String,
    val name: String,
    val kycField: String
)