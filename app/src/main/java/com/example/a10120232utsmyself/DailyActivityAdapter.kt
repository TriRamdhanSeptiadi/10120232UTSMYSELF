package com.example.a10120232utsmyself

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan DailyActivityAdapter  : 8 JUNI 2023
// NIM                                      : 10120232
// Nama                                     : Tri Ramdhan Septiadi
// Kelas                                    : IF-6

class DailyActivityAdapter(private val context: Context, private val dailyactivity: List<DailyActivity>, val listener: (DailyActivity) -> Unit)
    : RecyclerView.Adapter<DailyActivityAdapter.DailyActivityViewHolder>(){

    class DailyActivityViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgdailyactivity = view.findViewById<ImageView>(R.id.img_item_photo)
        val namedailyactivity = view.findViewById<TextView>(R.id.tv_item_name)

        fun bindView(dailiactivity: DailyActivity, listener: (DailyActivity) -> Unit){
            imgdailyactivity.setImageResource(dailiactivity.imgdailyactivity)
            namedailyactivity.text = dailiactivity.namedailyactivity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyActivityViewHolder {
        return DailyActivityViewHolder(LayoutInflater.from(context).inflate(R.layout.item_daily_activity, parent, false))
    }

    override fun getItemCount(): Int = dailyactivity.size

    override fun onBindViewHolder(holder: DailyActivityViewHolder, position: Int) {
        holder.bindView(dailyactivity[position], listener)
    }

}