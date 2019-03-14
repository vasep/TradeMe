package com.example.trademe.dashboardactivity.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.trademe.R
import javax.inject.Inject

class HorizontalDashRVAdapter @Inject constructor(private var context : Context): RecyclerView.Adapter<HorizontalDashRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rvnav_listitem, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView
        holder.txtCaption.setText("Books")
    }


    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        var imageView : ImageView = itemView.findViewById(R.id.ivCircleImage)
        var txtCaption : TextView = itemView.findViewById(R.id.tvImage)
    }
}