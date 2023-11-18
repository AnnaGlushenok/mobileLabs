package com.example.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.RelativeLayout

class ImageAdapter(private val context: Context) : BaseAdapter() {
    val images = listOf<Int>(
        R.drawable.but,
        R.drawable.but1,
        R.drawable.but3,
        R.drawable.but4,
        R.drawable.but5
    )

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView = ImageView(context)
        imageView.setImageResource(images[position])
        imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
        imageView.layoutParams = RelativeLayout.LayoutParams(120, 110)
        return imageView
    }
}