package com.example.practice3_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BlankFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val colorNames: Array<String> = resources.getStringArray(R.array.colorNames)
        val colorValues: Array<String> = resources.getStringArray(R.array.colorValues) as Array<String>

        recyclerView = view.findViewById(R.id.recyclerViewGgs)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CustomAdapter(colorNames,colorValues)

        super.onViewCreated(view, savedInstanceState)
    }
}