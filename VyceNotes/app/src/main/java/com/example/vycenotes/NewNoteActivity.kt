package com.example.vycenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vycenotes.databinding.ActivityNewNoteBinding

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}