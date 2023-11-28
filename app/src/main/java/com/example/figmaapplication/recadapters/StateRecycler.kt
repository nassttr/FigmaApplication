package com.example.figmaapplication.recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.figmaapplication.R

class StateRecycler(val context: Context, val state_list: ArrayList<state>) : RecyclerView.Adapter<StateRecycler.MyVH> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.feels_adapt, parent, false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.image.setImageResource(state_list[position].image_state)
    }

    class MyVH(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        val image:ImageView = itemView.findViewById(R.id.img_feel)
    }

    override fun getItemCount(): Int {
        return state_list.size
    }

}