package com.example.krishichain.network

import com.example.krishichain.data.entity.Batch
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("uploadBatch")
    suspend fun uploadBatch(@Body batch: Batch): ApiResponse

    @POST("transferOwnership")
    suspend fun transferOwnership(@Body transfer: TransferRequest): ApiResponse

    @GET("fetchBatch/{id}")
    suspend fun fetchBatch(@Path("id") id: String): Batch?

    @POST("simulateTx")
    suspend fun simulateTx(@Body tx: SimulateTxRequest): ApiResponse
}

data class ApiResponse(val success: Boolean, val txId: String?)
data class TransferRequest(val batchId: String, val toRetailerId: String)
data class SimulateTxRequest(val batchId: String)