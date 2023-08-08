package com.mala.task1

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.mala.task1.databinding.ItemCoustemPostBinding
import com.squareup.picasso.Picasso

class CoustemAdapter( var posts: ArrayList<Post>,var lisener:CoustemOnClickLisner):RecyclerView.Adapter<CoustemAdapter.ViewHolder>(){

    inner class ViewHolder(val binding:ItemCoustemPostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemCoustemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.binding.name.text=posts[position].name
        holder.binding.Date.text=posts[position].date
        holder.binding.comment.text=posts[position].comment
        if(posts[position].urlImage.isNotEmpty()){
            Picasso.get().load(posts[position].urlImage).into(holder.binding.image)
        }

        holder.binding.btnMore.setOnClickListener{
            lisener.onClickItem(posts[position],position)
        }
    }

    override fun getItemCount(): Int {
     return posts.size
    }
}