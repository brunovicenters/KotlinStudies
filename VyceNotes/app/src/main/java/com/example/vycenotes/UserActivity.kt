package com.example.vycenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vycenotes.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    
    lateinit var binding : ActivityUserBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}