package com.example.krishichain.network

import com.example.krishichain.data.entity.Batch
import kotlinx.coroutines.delay

class MockApi : ApiService {
    override suspend fun uploadBatch(batch: Batch): ApiResponse {
        delay(500)
        return ApiResponse(true, "TX-${System.currentTimeMillis()}")
    }

    override suspend fun transferOwnership(transfer: TransferRequest): ApiResponse {
        delay(500)
        return ApiResponse(true, "TX-${System.currentTimeMillis()}")
    }

    override suspend fun fetchBatch(id: String): Batch? {
        delay(300)
        return null // Simulate not found
    }

    override suspend fun simulateTx(tx: SimulateTxRequest): ApiResponse {
        delay(300)
        return ApiResponse(true, "TX-${System.currentTimeMillis()}")
    }
}