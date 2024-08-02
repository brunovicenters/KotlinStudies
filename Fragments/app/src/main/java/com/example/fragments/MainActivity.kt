package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlbum.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.container.id, AlbumFragment())
                .commit()
        }
    }
}