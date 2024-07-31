package com.example.aula3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent Implicito
        binding.btnPronome.setOnClickListener {
            val intent = Intent("com.example.aula3")
            startActivity(intent)
        }

        // Intent Explicito
        binding.btnPrefCon.setOnClickListener {
            val intent = Intent(this, PreferenciaContatoActivity::class.java)
            startActivity(intent)
        }

        binding.btnTipoTel.setOnClickListener {
            val intent = Intent(this, PhoneTypeActivity::class.java)
            startActivity(intent)
        }

        binding.btnDataHora.setOnClickListener {
            val intent = Intent(this, DateTimeActivity::class.java)
            startActivity(intent)
        }

        binding.btnImagem.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }
    }
}