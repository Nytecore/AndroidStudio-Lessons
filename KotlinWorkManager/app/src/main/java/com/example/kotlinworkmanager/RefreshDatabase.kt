package com.example.kotlinworkmanager

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.core.content.edit

class RefreshDatabase(private val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val getData = inputData
        val myNumber = getData.getInt("intKey",0)
        refreshDatabase(myNumber)
        return Result.success()
    }

    private fun refreshDatabase(myNumber: Int) {
        val sharedPreferences = context.getSharedPreferences("com.example.kotlinworkmanager" , Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber" , 0)
        mySavedNumber += myNumber
        println(mySavedNumber)
        sharedPreferences.edit { putInt("myNumber", mySavedNumber) }

    }
}