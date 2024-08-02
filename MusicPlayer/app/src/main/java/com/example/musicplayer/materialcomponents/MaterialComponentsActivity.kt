package com.example.musicplayer.materialcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ActivityMaterialComponentsBinding

class MaterialComponentsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMaterialComponentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}