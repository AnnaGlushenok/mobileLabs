package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ButterflyAdapter(val context: Context, val butterflies: List<Butterfly>) :
    RecyclerView.Adapter<ButterflyAdapter.ButterflyViewHolder>() {

    class ButterflyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButterflyViewHolder =
        ButterflyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        )

    override fun getItemCount(): Int = butterflies.size

    override fun onBindViewHolder(holder: ButterflyViewHolder, position: Int) {
        val butterfly = butterflies[position]
        holder.itemView.apply {
            findViewById<ImageView>(R.id.image_view).setImageResource(butterfly.image)
            findViewById<TextView>(R.id.name_text_view).text = butterfly.name
            findViewById<TextView>(R.id.population_text_view).text = butterfly.population.toString()
            setOnClickListener {
                Toast.makeText(context, butterfly.name, Toast.LENGTH_LONG).show()
            }
        }
    }
}
