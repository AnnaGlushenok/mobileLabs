package com.example.myapplication

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(private val context: Context, private val fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment = PageFragment.newInstance(position)

    override fun getPageTitle(position: Int): CharSequence? =
        PageFragment.getTitle(position)
}