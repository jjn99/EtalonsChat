package com.cours.etalonschat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cours.etalonschat.R
import com.cours.etalonschat.activities.ChatActivity
import com.cours.etalonschat.models.Friend
import com.cours.etalonschat.models.User
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserRecyclerAdapter : RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>(){

    var items : MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return  ViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = items[position]
        holder.bind(user)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val  tvShortName: TextView = itemView.findViewById(R.id.tvShortName)
        val tvName : TextView = itemView.findViewById(R.id.tvName)

        fun bind(user: User){
            tvName.text = user.fullName
            tvShortName.text = user.fullName[0].toString()
        }
    }
}