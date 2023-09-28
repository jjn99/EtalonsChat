package com.cours.etalonschat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cours.etalonschat.R
import com.cours.etalonschat.models.Friend
import com.google.android.material.imageview.ShapeableImageView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FriendsRecyclerAdapter:RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder>() {


    var items: MutableList<Friend> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_friends,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = items[position]
        holder.bind(friend)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val ivFriend:ShapeableImageView = itemView.findViewById(R.id.idFriend)
        val tvName:TextView = itemView.findViewById(R.id.idName)
        val tvLastMessage :TextView = itemView.findViewById(R.id.lastMessage)
        val tvHour:TextView = itemView.findViewById(R.id.tvHour)

        fun bind(friend: Friend){
            tvName.text = friend.name
            tvLastMessage.text = friend.lastMessage
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            tvHour.text = sdf.format(Date(friend.timestamp))
        }
    }
}