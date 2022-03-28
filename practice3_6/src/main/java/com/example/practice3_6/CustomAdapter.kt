package com.example.practice3_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val colorNames: Array<String>,private val colorsValues: IntArray): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textVew : TextView = itemView.findViewById(R.id.textViewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        holder.textVew.setBackgroundColor(colorsValues[position].toInt())
        holder.textVew.text = colorNames[position].toString()
        holder.textVew.setOnClickListener {
            //TODO вообще не понятно
        }
    }

    override fun getItemCount() = 140
}