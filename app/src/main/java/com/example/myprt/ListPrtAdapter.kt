package com.example.myprt

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPrtAdapter(private val listPRT: ArrayList<PRT>):RecyclerView.Adapter<ListPrtAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_prt, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, resume) = listPRT[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvResume.text = resume

        val parts = description.split(", ")
        val location = parts[0]
        val age = parts[1]
        val rating = parts[2]

        holder.tvLocation.text = location
        holder.tvAge.text = age
        holder.tvRating.text = rating

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("KEY_PRT", listPRT[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listPRT.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        val tvAge: TextView = itemView.findViewById(R.id.tv_item_age)
        val tvRating: TextView = itemView.findViewById(R.id.tv_item_rating)
        val tvResume: TextView = itemView.findViewById(R.id.tv_item_resume)
    }

}