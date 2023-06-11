package com.example.a10120232utsmyself

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan FriendListAdapter  : 8 JUNI 2023
// NIM                                   : 10120232
// Nama                                  : Tri Ramdhan Septiadi
// Kelas                                 : IF-6

class FriendListAdapter(private val context: Context, private val friendlist: List<FriendList>, val listener: (FriendList) -> Unit)
    : RecyclerView.Adapter<FriendListAdapter.FriendViewHolder>(){

    class FriendViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgdailyactivity = view.findViewById<ImageView>(R.id.img_item_photo_friend)
        val namedailyactivity = view.findViewById<TextView>(R.id.tv_item_name_friend)

        fun bindView(friendlist: FriendList, listener: (FriendList) -> Unit){
            imgdailyactivity.setImageResource(friendlist.imgfriendlist)
            namedailyactivity.text = friendlist.namefriendlist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(LayoutInflater.from(context).inflate(R.layout.item_friendlist, parent, false))
    }

    override fun getItemCount(): Int = friendlist.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bindView(friendlist[position], listener)
    }

}