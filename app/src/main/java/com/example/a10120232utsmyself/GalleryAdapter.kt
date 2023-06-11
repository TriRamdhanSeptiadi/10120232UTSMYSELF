package com.example.a10120232utsmyself

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan GalleryAdapter  : 8 JUNI 2023
// NIM                                : 10120232
// Nama                               : Tri Ramdhan Septiadi
// Kelas                              : IF-6

class GalleryAdapter(private val context: Context, private val gallerylist: List<Gallery>, val listener: (Gallery) -> Unit)
    : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>(){

    class GalleryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imggalleryactivity = view.findViewById<ImageView>(R.id.img_item_photo_gallery)

        fun bindView(gallerylist: Gallery, listener: (Gallery) -> Unit){
            imggalleryactivity.setImageResource(gallerylist.imggallerylist)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false))
    }

    override fun getItemCount(): Int = gallerylist.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bindView(gallerylist[position], listener)
    }

}