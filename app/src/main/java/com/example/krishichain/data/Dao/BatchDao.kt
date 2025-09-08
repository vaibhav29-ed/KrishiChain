package com.example.krishichain.data.dao

import androidx.room.*
import com.example.krishichain.data.entity.Batch

@Dao
interface BatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(batch: Batch)

    @Query("SELECT * FROM Batch WHERE id = :id")
    suspend fun getById(id: String): Batch?

    @Query("SELECT * FROM Batch")
    suspend fun getAll(): List<Batch>
}