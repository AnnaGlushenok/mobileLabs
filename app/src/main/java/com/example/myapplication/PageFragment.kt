package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class PageFragment : Fragment() {
    private var pageNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageNumber = arguments?.getInt("num") ?: 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        view.findViewById<TextView>(R.id.displayText).text = "Фрагмент ${pageNumber + 1}"
        return view
    }

    companion object {
        fun getTitle(position: Int): String = "Страница № ${position}"

        @JvmStatic
        fun newInstance(param1: Int) =
            PageFragment().apply {
                arguments = Bundle().apply {
                    putInt("num", param1)
                }
            }
    }
}