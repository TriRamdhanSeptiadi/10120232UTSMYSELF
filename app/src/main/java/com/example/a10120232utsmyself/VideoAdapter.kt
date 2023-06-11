package com.example.a10120232utsmyself

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan VideoAdapter   : 10 JUNI 2023
// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

class VideoAdapter(private val context: Context, private val videolist: List<Video>, val listener: (Video) -> Unit)
    : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){

    class VideoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val videoView = itemView.findViewById<VideoView>(R.id.videoplayer)
        private val mediaController = MediaController(itemView.context)

        init {
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
        }

        fun bindView(video: Video, listener: (Video) -> Unit) {
            videoView.setVideoURI(Uri.parse(video.videoUri))
            videoView.setOnPreparedListener { mp ->
                mp.setOnVideoSizeChangedListener { _, _, _ ->
                    videoView.start()
                }
            }
            itemView.setOnClickListener {
                listener(video)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_music, parent, false))
    }

    override fun getItemCount(): Int = videolist.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bindView(videolist[position], listener)
    }

}