package com.example.a10120232utsmyself

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.net.URLEncoder

// Tanggal Pengerjaan ProfileFragment  : 10 JUNI 2023
// NIM                                 : 10120232
// Nama                                : Tri Ramdhan Septiadi
// Kelas                               : IF-6

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val imageEmail = view.findViewById<ImageView>(R.id.imageemail)
        val imageWhatsapp = view.findViewById<ImageView>(R.id.openwhatapss)
        val imageinstagram = view.findViewById<ImageView>(R.id.imageinstagram)
        val imagelokasi = view.findViewById<ImageView>(R.id.imagelokasi)
        val btn = view.findViewById<Button>(R.id.buttonabout)

        val phoneNumber = "+6289663813738" // Ganti dengan nomor telepon yang sebenarnya
        imageWhatsapp.setOnClickListener {
            try {
                val uri = Uri.parse("https://wa.me/$phoneNumber")
                val sendIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(sendIntent)
            } catch (e: Exception) {
                e.printStackTrace()
                val appPackageName = "com.whatsapp"
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                } catch (e: android.content.ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                }
            }
        }



        imageEmail.setOnClickListener {

            val emailIntent = Intent(Intent.ACTION_SENDTO,
            Uri.fromParts("mailto", "triramdhan155@gmail.com", null))
            startActivity(Intent.createChooser(emailIntent, "Send Email ..."))

        }

        imageinstagram.setOnClickListener(View.OnClickListener{
            val uri = Uri.parse("https://instagram.com/_triramdhan?igshid=MzNlNGNkZWQ4Mg==")
            val instagram = Intent(Intent.ACTION_VIEW, uri)
            instagram.setPackage("com.instagram.android")
            try {
                startActivity(instagram)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_triramdhan?igshid=MzNlNGNkZWQ4Mg==")))
            }
        })

        imagelokasi.setOnClickListener(View.OnClickListener{
            val uri = Uri.parse("https://goo.gl/maps/zzgN6nq7KUwCru4cA")
            val maps = Intent(Intent.ACTION_VIEW, uri)
            maps.setPackage("com.google.android.apps.maps")
            try {
                startActivity(maps)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/zzgN6nq7KUwCru4cA")))
            }
        })

        btn.setOnClickListener{
            val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog, null)

            val myDialog = Dialog(requireContext())
            myDialog.setContentView(dialogBinding)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

            val closebtn = dialogBinding.findViewById<Button>(R.id.about_close)
            closebtn.setOnClickListener{
                myDialog.dismiss()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}