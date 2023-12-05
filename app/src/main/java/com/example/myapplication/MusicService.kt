package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
    private var player: MediaPlayer? = null

    override fun onCreate() {
        player = MediaPlayer.create(this, R.raw.deutschland)
        player?.isLooping = true
        super.onCreate()
    }

    override fun onDestroy() {
        player?.stop()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player?.start()
        Log.d("TAG", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}