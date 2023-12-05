package com.example.myapplication

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.imageView)
        image.setBackgroundResource(R.drawable.chel_animation)
        val frameAnimation: AnimationDrawable = image.background as AnimationDrawable
        findViewById<Button>(R.id.button).setOnClickListener {
            frameAnimation.start()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            frameAnimation.stop()
        }
        findViewById<SeekBar>(R.id.seek_bar)
            .setOnClickListener(object : OnSeekBarChangeListener, View.OnClickListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    frameAnimation.alpha = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    TODO("Not yet implemented")
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    TODO("Not yet implemented")
                }

                override fun onClick(v: View?) {
                    TODO("Not yet implemented")
                }

            })
    }
}
