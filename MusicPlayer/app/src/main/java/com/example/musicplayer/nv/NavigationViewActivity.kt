package com.example.musicplayer.nv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ActivityNavigationViewBinding
import com.example.musicplayer.fragments.AlbumsFragment
import com.example.musicplayer.fragments.ArtistsFragment
import com.example.musicplayer.fragments.RecentsFragment
import com.example.musicplayer.fragments.SettingsFragment

class NavigationViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityNavigationViewBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this, binding.drLayout, R.string.open_menu, R.string.close_menu)

        binding.drLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener {
            binding.drLayout.closeDrawers()

            when(it.itemId) {
                R.id.albuns -> {
                    val frag = AlbumsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
                R.id.artistas -> {
                    val frag = ArtistsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
                R.id.recentes -> {
                    val frag = RecentsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
                R.id.config -> {
                    val frag = SettingsFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.container.id, frag)
                        .commit()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

}