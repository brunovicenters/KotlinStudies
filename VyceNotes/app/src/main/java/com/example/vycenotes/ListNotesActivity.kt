package com.example.vycenotes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
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

        val textColor = PreferenceManager.getDefaultSharedPreferences(this)
            .getInt("textColor", Color.GRAY)
        val bgColor = PreferenceManager.getDefaultSharedPreferences(this)
            .getInt("noteColor", Color.GRAY)

        Notas.listaNotas.forEach {

            Log.d("ListNotesActivity", "Background color: $bgColor")
            Log.d("ListNotesActivity", "Text color: $textColor")


            val nota = NotaBinding.inflate(layoutInflater)
            nota.textTitulo.text = it.title
            nota.textDesc.text = it.desc
            nota.textUser.text = it.user

            nota.textTitulo.setTextColor(textColor)
            nota.textDesc.setTextColor(textColor)
            nota.textUser.setTextColor(textColor)
            nota.root.setCardBackgroundColor(bgColor)


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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.userMenuItem -> {
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
            R.id.configMenuItem -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}