package com.example.a10120232utsmyself

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan GalleryFragment  : 8 JUNI 2023
// NIM                                 : 10120232
// Nama                                : Tri Ramdhan Septiadi
// Kelas                               : IF-6

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GalleryFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val gallerylist = listOf<Gallery>(
            Gallery(
                R.drawable.gallery_1
            ),
            Gallery(
                R.drawable.gallery_2
            ),
            Gallery(
                R.drawable.gallery_3
            ),
            Gallery(
                R.drawable.gallery_4
            ),
            Gallery(
                R.drawable.gallery_5
            ),
            Gallery(
                R.drawable.gallery_6
            ),
            Gallery(
                R.drawable.gallery_7
            ),
            Gallery(
                R.drawable.gallery_8,
            ),
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_gallery)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = GalleryAdapter(requireContext(), gallerylist) {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DailyActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}