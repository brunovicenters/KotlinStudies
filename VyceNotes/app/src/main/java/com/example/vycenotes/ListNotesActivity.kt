package com.example.vycenotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.vycenotes.databinding.ActivityListNotesBinding
import com.example.vycenotes.databinding.NotaBinding
import com.google.android.material.snackbar.Snackbar

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

    override fun onResume() {
        super.onResume()
        updateNotes()
        if (Notas.newNote) {
            Snackbar.make(this, binding.root, "Anotação criada!", Snackbar.LENGTH_SHORT).show()
            Notas.newNote = false
        }
    }

    fun updateNotes() {

        binding.container.removeAllViews()

        Notas.listaNotas.forEach {

            val nota = NotaBinding.inflate(layoutInflater)
            nota.textTitulo.text = it.title
            nota.textDesc.text = it.desc

            nota.root.setOnClickListener { card ->
                val i = Intent(this, NewNoteActivity::class.java)
                i.putExtra("title", it.title)
                i.putExtra("desc", it.desc)
                startActivity(i)
            }

            binding.container.addView(nota.root)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }
}