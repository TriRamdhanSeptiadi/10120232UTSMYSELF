package com.example.a10120232utsmyself

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Tanggal Pengerjaan FriendList     : 8 JUNI 2023
// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

@Parcelize
data class FriendList(
    val imgfriendlist: Int,
    val namefriendlist: String
) : Parcelable