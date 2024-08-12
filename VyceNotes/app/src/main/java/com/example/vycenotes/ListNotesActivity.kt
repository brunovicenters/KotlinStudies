package com.example.vycenotes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import androidx.room.Room
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
        if (Notas.erro) {
            Snackbar.make(this, binding.root, "Erro!", Snackbar.LENGTH_SHORT)
            Notas.erro = false
        }
        if (Notas.updated) {
            Snackbar.make(this, binding.root, "Atualizado com sucesso!", Snackbar.LENGTH_SHORT).show()
            Notas.updated = false
        }
    }

    fun updateNotes() {

        binding.container.removeAllViews()

        val textColor = PreferenceManager.getDefaultSharedPreferences(this)
            .getInt("textColor", Color.GRAY)
        val bgColor = PreferenceManager.getDefaultSharedPreferences(this)
            .getInt("noteColor", Color.GRAY)

        val db = getDb(this)

        Thread{
            val notas = db.notaDao().getAll()
            runOnUiThread {
                notas.forEach { notaEntity ->

                    val nota = NotaBinding.inflate(layoutInflater)
                    nota.textTitulo.text = notaEntity.title
                    nota.textDesc.text = notaEntity.desc
                    nota.textUser.text = notaEntity.user

                    nota.textTitulo.setTextColor(textColor)
                    nota.textDesc.setTextColor(textColor)
                    nota.textUser.setTextColor(textColor)
                    nota.root.setCardBackgroundColor(bgColor)

                    nota.btnDelete.setOnClickListener {
                        Thread {
                            db.notaDao().delete(notaEntity)
                            runOnUiThread {
                                updateNotes()
                                Snackbar.make(binding.root, "Nota deletada com sucesso!", Snackbar.LENGTH_SHORT).show()
                            }
                        }.start()
                    }


                    nota.root.setOnClickListener { card ->
                        val i = Intent(this, UpdateActivity::class.java)
                        i.putExtra("title", notaEntity.title)
                        i.putExtra("desc", notaEntity.desc)
                        i.putExtra("id", notaEntity.id)
                        startActivity(i)
                    }

                    binding.container.addView(nota.root)

                }
            }
        }.start()

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