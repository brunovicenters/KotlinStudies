package com.example.musicplayer.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityBottomNavigationBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}