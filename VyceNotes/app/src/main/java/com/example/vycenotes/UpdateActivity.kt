package com.example.vycenotes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.vycenotes.databinding.ActivityUpdateBinding
import com.google.android.material.snackbar.Snackbar

class UpdateActivity : AppCompatActivity() {
    lateinit var binding : ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getStringExtra("title") != null) {
            binding.etUpTitle.setText(intent.getStringExtra("title"))
            binding.etUpDesc.setText(intent.getStringExtra("desc"))
        } else {
            Notas.erro = true
            val i = Intent(this, ListNotesActivity::class.java)
            startActivity(i)
        }

        val userPref = getSharedPreferences("user_vnotes", Context.MODE_PRIVATE)

        var username = userPref.getString("user", "")
        if (username == null) username = ""

        val db = getDb(this)

        binding.btnUpdate.setOnClickListener {
            val nota = Nota(
                id = intent.getIntExtra("id", 0),
                title = binding.etUpTitle.text.toString(),
                desc = binding.etUpDesc.text.toString(),
                user = username
            )

            Log.w("EU TO AQUI", "AQUI A NOTA NOVA:" + binding.etUpTitle.text.toString())

            Thread {
                db.notaDao().update(nota)
                Notas.updated = true
                finish()
            }.start()
        }

    }
}