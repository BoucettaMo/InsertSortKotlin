package com.example.sortingappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(private val context: Context,private val list:Array<String>,private val key:Int,private val color:Int):RecyclerView.Adapter<MyAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.model_item,parent,false)
    return ViewHolder(view)
    }

    override fun getItemCount()=25

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text=list[position]
        holder.button.setBackgroundColor(ContextCompat.getColor(context,color))
        if (position==key) {
            holder.button.setBackgroundColor(ContextCompat.getColor(context,R.color.red))
        }

    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById<Button>(R.id.button)

    }
}
