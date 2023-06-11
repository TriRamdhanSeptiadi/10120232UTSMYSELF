package com.example.a10120232utsmyself

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan MusicFragment  : 10 JUNI 2023
// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val videolist = listOf<Video>(
            Video("android.resource://" + requireContext().packageName + "/" + R.raw.video1),
            Video("android.resource://" + requireContext().packageName + "/" + R.raw.video2),
            Video("android.resource://" + requireContext().packageName + "/" + R.raw.video3),
            Video("android.resource://" + requireContext().packageName + "/" + R.raw.video4),
            Video("android.resource://" + requireContext().packageName + "/" + R.raw.video5),
            Video("android.resource://" + requireContext().packageName + "/" + R.raw.video6)
        )

        val musiclist = listOf<Music>(
            Music(
                "Superman Is Dead - Punk Hari Ini"
            ),
            Music(
                "Bring Me To Horizon - Kingslayer"
            ),
            Music(
                "Burgerkill - Tiga Titik Hitam"
            ),
            Music(
                "Noin Bullet - I Never"
            ),
            Music(
                "Green Day - Basket Case"
            ),
            Music(
                "Motorhead - Ace Of Spades"
            )
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_video_music)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = VideoAdapter(requireContext(), videolist) {

        }

        val recyclerView1 = view.findViewById<RecyclerView>(R.id.rv_music_list)
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.setHasFixedSize(true)
        recyclerView1.adapter = MusicAdapter(requireContext(), musiclist) {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}