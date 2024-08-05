package com.example.musicplayer.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ActivityBottomNavigationBinding
import com.example.musicplayer.fragments.AlbumsFragment
import com.example.musicplayer.fragments.ArtistsFragment
import com.example.musicplayer.fragments.RecentsFragment
import com.example.musicplayer.fragments.SettingsFragment
import com.google.android.material.navigation.NavigationBarView

class BottomNavigationActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityBottomNavigationBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var frag: Fragment = AlbumsFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, frag)
            .commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.albuns -> {
                    frag = AlbumsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
                R.id.recentes -> {
                    frag = RecentsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
                R.id.artistas -> {
                    frag = ArtistsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
                R.id.configuracoes -> {
                    frag = SettingsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
            }
            true
        }
    }
}