package com.example.a10120232utsmyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

// Tanggal Pengerjaan SplashScreenActivity  : 29 MEI 2023
// NIM                                      : 10120232
// Nama                                     : Tri Ramdhan Septiadi
// Kelas                                    : IF-6

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,WalkthroughScreenActivity::class.java)
            startActivity(intent)
            finish()
        },2000)

    }
}
