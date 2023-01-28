package com.tasnim.chowdhury.newhomepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GuestUserHotJobsCompanyJobsAdapter: RecyclerView.Adapter<GuestUserHotJobsCompanyJobsAdapter.MyViewHolder>() {

    var onItemClick: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guest_user_bottom_sheet_jobs_rv_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return 7
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}