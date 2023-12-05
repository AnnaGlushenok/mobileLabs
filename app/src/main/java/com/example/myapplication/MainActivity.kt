package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }
        findViewById<Button>(R.id.button1).setOnClickListener {
            stopService(Intent(this, MyService::class.java))
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            startService(Intent(this, MusicService::class.java))
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            stopService(Intent(this, MusicService::class.java))
        }
    }
}
