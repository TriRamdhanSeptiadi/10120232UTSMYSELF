package com.example.a10120232utsmyself

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan Music Adapter  : 10 JUNI 2023
// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

class MusicAdapter(private val context: Context, private val musiclist: List<Music>, val listener: (Music) -> Unit)
    : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>(){

    class MusicViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val namemusicactivity = view.findViewById<TextView>(R.id.tv_item_music)

        fun bindView(musiclist: Music, listener: (Music) -> Unit){
            namemusicactivity.text = musiclist.namemusiclist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(LayoutInflater.from(context).inflate(R.layout.item_music_list, parent, false))
    }

    override fun getItemCount(): Int = musiclist.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bindView(musiclist[position], listener)
    }

}