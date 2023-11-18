package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val butterflies = listOf(
            Butterfly("Голубянка", R.drawable.but, 200000),
            Butterfly("Пестрокрыльнича", R.drawable.but1, 345000),
            Butterfly("Павлиний глаз", R.drawable.but3, 345620),
            Butterfly("Moнаpx", R.drawable.but4, 2341567),
            Butterfly("Адмирал", R.drawable.but5, 8765400)
        )
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter: ButterflyAdapter = ButterflyAdapter(this, butterflies)
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = adapter
    }
}