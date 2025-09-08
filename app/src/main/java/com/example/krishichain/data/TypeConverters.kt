package com.example.krishichain.data

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromList(list: List<String>): String = Gson().toJson(list)

    @TypeConverter
    fun toList(json: String): List<String> =
        Gson().fromJson(json, Array<String>::class.java).toList()
}