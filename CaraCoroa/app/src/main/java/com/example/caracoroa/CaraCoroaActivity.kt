package com.example.caracoroa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toLowerCase
import com.example.caracoroa.databinding.ActivityCaraCoroaBinding

class CaraCoroaActivity : AppCompatActivity() {

    lateinit var binding: ActivityCaraCoroaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaraCoroaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJogar.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("player", binding.etNome.text.toString())
            intent.putExtra("choice", binding.etCaraCoroa.text.toString().lowercase())
            startActivity(intent)
        }

    }
}