package com.example.krishichain.data.repository

import com.example.krishichain.data.dao.BatchDao
import com.example.krishichain.data.entity.Batch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BatchRepository(private val batchDao: BatchDao) {
    suspend fun insert(batch: Batch) = batchDao.insert(batch)
    suspend fun getById(id: String) = batchDao.getById(id)
    suspend fun getAll() = batchDao.getAll()
    fun getAllFlow(): Flow<List<Batch>> = flow { emit(batchDao.getAll()) }
}