/*
 * Copyright (c) 2021 Roku Inc. All rights reserved.
 */
package io.ashpak.test

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import io.ashpak.test.domain.model.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class EventApiWorker(val appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {


    @Suppress("LabeledExpression")
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
                if (true) {
                    return@withContext Result.success()
                } else {
                    return@withContext Result.failure(
                        buildFailedStatus()
                    )
                }
        }
    }

    private fun buildFailedStatus(): Data {
        val errorData = Data.Builder()

        return errorData.build()
    }


    private fun parseData(): Event {
        return Event(
            inputData.getLong(UID,0),
            inputData.getLong(BOOT_COUNT,0),
            inputData.getLong(LAST_TIME,0),
        )
    }


    companion object {

        const val UID = "UID"
        private const val BOOT_COUNT = "BOOT_COUNT"
        private const val LAST_TIME = "LAST_TIME"

        fun createData(inputData: Event): Data {
            return Data.Builder()
                .putLong(UID, inputData.uid)
                .putLong(BOOT_COUNT, inputData.bootCount)
                .putLong(LAST_TIME, inputData.lastTime)
                .build()
        }
    }
}
