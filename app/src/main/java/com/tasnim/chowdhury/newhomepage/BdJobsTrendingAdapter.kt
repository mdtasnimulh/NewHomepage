package com.tasnim.chowdhury.newhomepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BdJobsTrendingAdapter: RecyclerView.Adapter<BdJobsTrendingAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bdjobs_trending_rv_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}