package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val gridView: GridView = findViewById(R.id.gridView)
        gridView.adapter = ImageAdapter(this)
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            startActivity(
                Intent(applicationContext, FullImageActivity::class.java)
                    .putExtra("id", position)
            )
        }
    }
}