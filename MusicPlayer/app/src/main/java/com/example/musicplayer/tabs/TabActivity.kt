package com.example.musicplayer.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ActivityTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {

    lateinit var binding : ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter: TabPageAdapter = TabPageAdapter(this)
        binding.vwPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.vwPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Albuns"
                    tab.icon = getDrawable(R.drawable.albumicon)
                }
                1 -> {
                    tab.text = "Recentes"
                    tab.icon = getDrawable(R.drawable.historyicon)
                }
                2 -> {
                    tab.text = "Artistas"
                    tab.icon = getDrawable(R.drawable.personicon)
                }
                3 -> {
                    tab.text = "Config."
                    tab.icon = getDrawable(R.drawable.settingsicon)
                }
            }
        }.attach()
    }
}