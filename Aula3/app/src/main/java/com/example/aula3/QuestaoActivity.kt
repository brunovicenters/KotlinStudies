package com.example.aula3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityQuestaoBinding

class QuestaoActivity : AppCompatActivity() {

    lateinit var binding : ActivityQuestaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtEnun.text = intent.getStringExtra("enunciado")
        binding.btnResp1.text = intent.getIntExtra("res1", 0).toString()
        binding.btnResp2.text = intent.getIntExtra("res2", 0).toString()
        binding.btnResp3.text = intent.getIntExtra("res3", 0).toString()

        binding.btnResp1.setOnClickListener { resposta(0) }
        binding.btnResp2.setOnClickListener { resposta(1) }
        binding.btnResp3.setOnClickListener { resposta(2) }
    }

    fun resposta(res: Int) {
        val respIntent = Intent()

        // Salva a resposta
        respIntent.putExtra("resposta", res)

        // Passa o resultado
        setResult(RESULT_OK, respIntent)

        // Encerra a Activity
        finish()
    }
}