package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {
    private val player: MediaPlayer? = null

    override fun onCreate() {
//        val l = SoundPool(4, AudioManager.STREAM_MUSIC, 100)
//        l.load(this, R.raw.music, 1)
//        val player = MediaPlayer(this, R.raw.music)
//        player.isLooping = true
        super.onCreate()
    }

    override fun onDestroy() {
        player?.stop()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}