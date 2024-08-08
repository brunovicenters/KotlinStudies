package com.example.vycenotes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vycenotes.databinding.ActivityNewNoteBinding

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getStringExtra("title") != null) {
            binding.etTitle.setText(intent.getStringExtra("title"))
            binding.etDesc.setText(intent.getStringExtra("desc"))
        }

        val userPref = getSharedPreferences("user_vnotes", Context.MODE_PRIVATE)

        var username = userPref.getString("user", "")
        if (username == null) username = ""

        binding.btnAdd.setOnClickListener {
            val nota : Nota = Nota(
                binding.etTitle.text.toString(),
                binding.etDesc.text.toString(),
                username)

            Notas.listaNotas.add(nota)
            Notas.newNote = true
            finish()
        }
    }
}