package com.example.kotlinworkmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = Data.Builder().putInt("intKey",1).build()

        val constraints = Constraints.Builder()
            //.setRequiredNetworkType(NetworkType.CONNECTED) ---> İnternete bağlıysa
            //.setRequiresBatteryNotLow() ---> Pil gücü az değilse
            //.setRequiresCharging() ---> Telefon şarj olması durumunda
            .setRequiresCharging(false)
            .build()

        /*

          // OneTimeWorkRequest

        val myWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            //.setInitialDelay(5,TimeUnit.MINUTES) ---> delay ekleyerek gecikmeli başlatır.
            //.addTag("myTag") ---> istedğimize bir tag ekleyerek ayrıştırmamızı sağlar.
            .setConstraints(constraints)    // ---> oluşturduğumuz constraintleri ekleriz.
            .setInputData(data)     // ---> verimizi, isteğimiz ile birlikte göndermemizi sağlar.
            .build()    // ---> başlatır.

        WorkManager.getInstance(this).enqueue(myWorkRequest)
        */


            // PeriodicWorkRequest
        val myWorkRequest: PeriodicWorkRequest = PeriodicWorkRequestBuilder<RefreshDatabase>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id).observe(this, Observer {

            it?.let {
                when (it.state) {
                    WorkInfo.State.RUNNING -> { println("Running") }
                    WorkInfo.State.FAILED -> { println("Failed") }
                    WorkInfo.State.SUCCEEDED -> { println("Succeeded") }
                    else -> {
                        println("Other")
                    }
                }
            }

        })

        //Chaining Work
        val oneTimeRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).beginWith(oneTimeRequest)
            .then(oneTimeRequest)
            .then(oneTimeRequest)
            .enqueue()


            // Cancel all work
        WorkManager.getInstance(this).cancelAllWork()

    }
}