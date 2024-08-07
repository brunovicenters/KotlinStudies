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

        if (intent.getStringExtra("title") != null) {
            binding.etTitle.setText(intent.getStringExtra("title"))
            binding.etDesc.setText(intent.getStringExtra("desc"))
        }

        binding.btnAdd.setOnClickListener {
            val nota : Nota = Nota(binding.etTitle.text.toString(), binding.etDesc.text.toString())
            Notas.listaNotas.add(nota)
            Notas.newNote = true
            finish()
        }
    }
}