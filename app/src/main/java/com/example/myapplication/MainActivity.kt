package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.txt)
        image = findViewById(R.id.img)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchItem: MenuItem = menu!!.findItem(R.id.action_pig1)
        val searchView: EditText = MenuItemCompat.getActionView(searchItem) as EditText
        searchView.hint = "Набирай что-нибудь"
        searchView.setOnFocusChangeListener { v, hasFocus -> text.text = searchView.text }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                text.text = "Что-то настраивается"
                return true
            }

            R.id.action_pig1 -> {
                text.text = ""
                image.setImageResource(R.drawable.but)
                return true
            }

            R.id.action_pig2 -> {
                text.text = "Хряк"
                image.setImageResource(R.drawable.but1)
                return true
            }

            R.id.action_pig3 -> {
                text.text = "Боров"
                image.setImageResource(R.drawable.but2)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}