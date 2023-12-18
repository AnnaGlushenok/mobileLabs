package com.example.myapplication

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val RAW_VIDEO: String = "bobr_1"
    private val LOCAL_VIDEO: String = "/storage/self/primary/DCIM/video_mp.mp4"
    private val URL_VIDEO: String = "http://techslides.com/demos/sample-videos/small.mp4"
    private lateinit var player: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player = findViewById(R.id.player)
        val myVideoUri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.bobr)
        player.setVideoURI(myVideoUri)

        val mediaController = MediaController(this)
        player.setMediaController(mediaController)
        mediaController.setMediaPlayer(player)
        player.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer?) {
                player.seekTo(0)
                player.start()
                mp?.setOnVideoSizeChangedListener { mp, width, height ->
                    mediaController.setAnchorView(
                        player
                    )
                }
            }
        })

        findViewById<Button>(R.id.buttonRaw).setOnClickListener {
            VideoService.playRawVideo(this@MainActivity, player, RAW_VIDEO)
        }
        findViewById<Button>(R.id.buttonLocal).setOnClickListener {
            VideoService.playLocalVideo(
                this@MainActivity,
                player,
                LOCAL_VIDEO
            )
        }
        findViewById<Button>(R.id.buttonURL).setOnClickListener {
            VideoService.playURLVideo(this@MainActivity, player, URL_VIDEO)
        }
        findViewById<Button>(R.id.buttonPause).setOnClickListener { player.pause() }
        findViewById<Button>(R.id.buttonStop).setOnClickListener { player.stopPlayback(); player.resume() }
        findViewById<Button>(R.id.buttonStart).setOnClickListener { player.start() }
    }
}
