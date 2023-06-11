package com.example.a10120232utsmyself

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan DailyActivityFragment  : 8 JUNI 2023
// NIM                                       : 10120232
// Nama                                      : Tri Ramdhan Septiadi
// Kelas                                     : IF-6

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DailyActivityFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val friendlist = listOf<FriendList>(
            FriendList(
                R.drawable.fajar,
                "FAJAR"
            ),
            FriendList(
                R.drawable.fahmi,
                "FAHMI"
            ),
            FriendList(
                R.drawable.faris,
                "FARIS"
            ),
            FriendList(
                R.drawable.adit,
                "ADIT"
            ),
            FriendList(
                R.drawable.abyan,
                "ABYAN"
            ),
            FriendList(
                R.drawable.rahmat,
                "RACHMAT"
            ),
            FriendList(
                R.drawable.adi,
                "ADI"
            )
        )

        val dailyactivitylist = listOf<DailyActivity>(
            DailyActivity(
                R.drawable.bangun,
                "Bangun Tidur"
            ),
            DailyActivity(
                R.drawable.mandi,
                "Mandi"
            ),
            DailyActivity(
                R.drawable.sarapan,
                "Sarapan"
            ),
            DailyActivity(
                R.drawable.belajar,
                "Belajar"
            ),
            DailyActivity(
                R.drawable.videogames,
                "Bermain Games"
            ),
            DailyActivity(
                R.drawable.tidur,
                "Tidur"
            )
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_activity)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DailyActivityAdapter(requireContext(), dailyactivitylist) {

        }

        val recyclerView1 = view.findViewById<RecyclerView>(R.id.rv_friend)
        recyclerView1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.setHasFixedSize(true)
        recyclerView1.adapter = FriendListAdapter(requireContext(), friendlist) {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_activity, container, false)
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
