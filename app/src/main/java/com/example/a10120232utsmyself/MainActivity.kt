package com.example.a10120232utsmyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.a10120232utsmyself.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// Tanggal Pengerjaan MainActivity   : 8 JUNI 2023
// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val homeFragment = HomeFragment()
        val dailyActivityFragment = DailyActivityFragment()
        val galleryFragment = GalleryFragment()
        val musicFragment = MusicFragment()
        val profileFragment = ProfileFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replaceFragment(homeFragment)

        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.item_home -> replaceFragment(homeFragment)
                R.id.item_activity -> replaceFragment(dailyActivityFragment)
                R.id.item_gallery -> replaceFragment(galleryFragment)
                R.id.item_music -> replaceFragment(musicFragment)
                R.id.item_profile -> replaceFragment(profileFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fl, fragment)
            transaction.commit()
        }
    }
}