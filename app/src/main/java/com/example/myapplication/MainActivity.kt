package com.example.myapplication

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.imageView)
        image.setBackgroundResource(R.drawable.chel_animation)
        image.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim))
        val frameAnimation: AnimationDrawable = image.background as AnimationDrawable
        findViewById<Button>(R.id.button).setOnClickListener {
            frameAnimation.start()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            frameAnimation.stop()
        }
        findViewById<SeekBar>(R.id.seek_bar)
            .setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
//                    Log.d("TAG", "seek click")
                    frameAnimation.alpha = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })
    }
}
