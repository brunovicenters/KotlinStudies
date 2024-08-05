package com.example.musicplayer.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicplayer.fragments.AlbumsFragment
import com.example.musicplayer.fragments.ArtistsFragment
import com.example.musicplayer.fragments.RecentsFragment
import com.example.musicplayer.fragments.SettingsFragment

private const val TAB_COUNT = 4

class TabPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    override fun createFragment(p: Int): Fragment {
        return when(p) {
            0 -> AlbumsFragment.newInstance()
            1 -> RecentsFragment.newInstance()
            2 -> ArtistsFragment.newInstance()
            else -> SettingsFragment.newInstance()
        }
    }

}