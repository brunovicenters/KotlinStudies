package com.example.vycenotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vycenotes.databinding.ActivityListNotesBinding

class ListNotesActivity : AppCompatActivity() {

    lateinit var binding: ActivityListNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val i = Intent(this, NewNoteActivity::class.java)
            startActivity(i)
        }
    }
}