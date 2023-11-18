package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        val position: Int = intent.getIntExtra("id", 0)
        val imageAdapter = ImageAdapter(this)
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(imageAdapter.images[position])
    }
}