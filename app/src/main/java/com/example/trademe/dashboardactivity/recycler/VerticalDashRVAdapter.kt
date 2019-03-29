package com.example.trademe.dashboardactivity.recycler

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.trademe.R
import com.example.trademe.models.Posts
import javax.inject.Inject

class VerticalDashRVAdapter @Inject constructor(var quizItemListener: QuizItemListener, var mposts : ArrayList<Posts> ) :
    RecyclerView.Adapter<VerticalDashRVAdapter.GridHolder>() {

     var mQuizItemListener: QuizItemListener

    init {

        this.mQuizItemListener = quizItemListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GridHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_rv, parent, false)
        return GridHolder(view)
    }

    override fun getItemCount(): Int {
        return mposts.size
    }

    override fun onBindViewHolder(holder: GridHolder, position: Int) {
        holder.imageView.setImageBitmap(mposts.get(position).image)
        holder.txtCaption.setText("Caption " + position)
    }

    class GridHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView = itemView.findViewById(R.id.ivMainImage)
        var txtCaption: TextView = itemView.findViewById(R.id.txTextCaption)

        fun onPostClick(position: Int) {

            itemView.setOnClickListener {

            }
        }

    }

    fun loadPosts(posts: ArrayList<Posts>) {
        mposts.clear()
        mposts.addAll(posts)
    }

    interface QuizItemListener {
        /**
         * Called when quiz is clicked
         *
         * @param post the Post that was clicked
         */
        fun onQuizClicked(post: Posts)


    }
}