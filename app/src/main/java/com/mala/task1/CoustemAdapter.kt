package com.mala.task1

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.mala.task1.databinding.ItemCoustemPostBinding

import com.mala.task1.Core.model.Post

class CoustemAdapter(var postsList: ArrayList<Post>, var lisner:CoustemOnClickLisner):RecyclerView.Adapter<CoustemAdapter.ViewHolder>(){

    inner class ViewHolder(val binding:ItemCoustemPostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemCoustemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.binding.name.text="UserId ${postsList[position].userid}"
        holder.binding.Date.text="PostId ${postsList[position].id}"
        holder.binding.titleeee.text=postsList[position].title
        holder.binding.comment2.text=postsList[position].body
  /*
        if(Userlist[position].avatar.isNotEmpty()){
            Picasso.get().load(Userlist[position].avatar).into(holder.binding.image)
        }

*/
        holder.binding.btnMore.setOnClickListener {
            lisner.onClickItem(postsList[position] ,position)
        }

    }


    override fun getItemCount(): Int {
     return postsList.size
    }


}