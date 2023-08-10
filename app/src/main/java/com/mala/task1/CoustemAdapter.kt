package com.mala.task1

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.mala.task1.databinding.ItemCoustemPostBinding
import com.mala.task1.model.User
import com.squareup.picasso.Picasso

class CoustemAdapter(var Userlist: List<User>):RecyclerView.Adapter<CoustemAdapter.ViewHolder>(){

    inner class ViewHolder(val binding:ItemCoustemPostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemCoustemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.binding.name.text="${Userlist[position].firstname} ${Userlist[position].lastName}"
        holder.binding.Date.text="${Userlist[position].id}"
        holder.binding.comment.text=Userlist[position].email
        if(Userlist[position].avatar.isNotEmpty()){
            Picasso.get().load(Userlist[position].avatar).into(holder.binding.image)
        }


    }

    override fun getItemCount(): Int {
     return Userlist.size
    }
}