package com.example.krishichain.data.dao

import androidx.room.*
import com.example.krishichain.data.entity.UserProfile

@Dao
interface UserProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: UserProfile)

    @Query("SELECT * FROM UserProfile WHERE id = :id")
    suspend fun getById(id: String): UserProfile?
}