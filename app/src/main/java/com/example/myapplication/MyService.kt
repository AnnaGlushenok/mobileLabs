package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.TimeUnit

class MyService : Service() {
    val TAG = "logs"

    fun veryImportantTask() {
        Thread(Runnable {
            for (i in 1..10) {
                Log.d(TAG, "число: $i")
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            stopSelf()
        }).start()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        veryImportantTask()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "onBind")
        return null
    }
}