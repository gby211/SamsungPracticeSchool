package com.example.practice3_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val persons: List<Person>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewPhone: TextView = itemView.findViewById(R.id.textViewTelephone)
        val imageViewSex: ImageView = itemView.findViewById(R.id.imageViewSex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person : Person = persons[position]
        holder.textViewName.text = "ggs"
        holder.textViewPhone.text = "123"
//        holder.imageViewSex. =
    }

    override fun getItemCount() = persons.size


}