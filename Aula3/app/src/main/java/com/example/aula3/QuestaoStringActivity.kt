package com.example.aula3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityQuestaoBinding
import com.example.aula3.databinding.ActivityQuestaoStringBinding

class QuestaoStringActivity : AppCompatActivity() {

    lateinit var binding : ActivityQuestaoStringBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestaoStringBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.txtStringEnun.text = intent.getStringExtra("enunciado")
        binding.btnStringResp1.text = intent.getStringExtra("res1")
        binding.btnStringResp2.text = intent.getStringExtra("res2")
        binding.btnStringResp3.text = intent.getStringExtra("res3")

        binding.btnStringResp1.setOnClickListener { resposta(0) }
        binding.btnStringResp2.setOnClickListener { resposta(1) }
        binding.btnStringResp3.setOnClickListener { resposta(2) }
    }

    fun resposta(res: Int) {
        val respIntent = Intent()

        // Salva a resposta
        respIntent.putExtra("resposta", res)

        when(res) {
            0 -> respIntent.putExtra("label", binding.btnStringResp1.text)
            1 -> respIntent.putExtra("label", binding.btnStringResp2.text)
            2 -> respIntent.putExtra("label", binding.btnStringResp3.text)
        }

        // Passa o resultado
        setResult(RESULT_OK, respIntent)

        // Encerra a Activity
        finish()
    }
}