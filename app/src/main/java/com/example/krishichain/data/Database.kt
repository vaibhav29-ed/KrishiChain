package com.example.krishichain.data

class Databasepackage com.example.krishichain.data

import android.content.Context
import androidx.room.*
import com.example.krishichain.data.dao.BatchDao
import com.example.krishichain.data.dao.UserProfileDao
import com.example.krishichain.data.entity.Batch
import com.example.krishichain.data.entity.UserProfile

@Database(entities = [Batch::class, UserProfile::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun batchDao(): BatchDao
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "krishichain.db"
                ).build().also { INSTANCE = it }
            }
    }
} {
}