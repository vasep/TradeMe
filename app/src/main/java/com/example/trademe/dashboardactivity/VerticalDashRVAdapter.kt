package com.example.trademe.dashboardactivity

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.trademe.R
import javax.inject.Inject

class VerticalDashRVAdapter @Inject constructor(private var bitmap: ArrayList<Bitmap>, private var context : Context): RecyclerView.Adapter<VerticalDashRVAdapter.GridHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_rv, p0, false)
        return GridHolder(view)
    }

    override fun getItemCount(): Int {
        return bitmap.size
    }

    override fun onBindViewHolder(holder: GridHolder, position: Int) {
        holder.imageView.setImageBitmap(bitmap[position])
        holder.txtCaption.setText("Caption " + position)
    }


    class GridHolder (itemView : View) : RecyclerView.ViewHolder(itemView)   {
        var imageView : ImageView = itemView.findViewById(R.id.ivMainImage)
        var txtCaption : TextView = itemView.findViewById(R.id.txTextCaption)
    }
}