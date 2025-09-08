package com.example.krishichain.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.krishichain.data.AppDatabase
import com.example.krishichain.network.MockApi
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters
) : Worker(context, params) {
    override fun doWork(): Result {
        val db = AppDatabase.getInstance(applicationContext)
        val batchDao = db.batchDao()
        val unsynced = batchDao.getAll().filter { !it.synced }
        val api = MockApi()
        unsynced.forEach { batch ->
            val response = api.uploadBatch(batch)
            if (response.success) {
                batchDao.insert(batch.copy(synced = true, onChainTxId = response.txId))
            }
        }
        return Result.success()
    }
}