package com.example.a10120232utsmyself

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Tanggal Pengerjaan OnBoardingItemAdapter  : 5 JUNI 2023
// NIM                                       : 10120232
// Nama                                      : Tri Ramdhan Septiadi
// Kelas                                     : IF-6

class OnboardingItemsAdapter(private val onboardingItem: List<OnboardingItem>) : RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItem[position])
    }

    override fun getItemCount(): Int {
        return onboardingItem.size
    }

    inner class OnboardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageOnboarding = view.findViewById<ImageView>(R.id.imageOnBoarding)
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)

        fun bind(onboardingItem: OnboardingItem) {
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            textTitle.text = onboardingItem.title
            textDescription.text = onboardingItem.description
        }
    }
}