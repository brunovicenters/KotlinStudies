package com.example.aula3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnQuestao1.setOnClickListener {
            val intent = Intent(this, QuestaoActivity::class.java)
            intent.putExtra("enunciado", "Quantos anos eu(Bruno Vicente) tenho?")
            intent.putExtra("res1", 16)
            intent.putExtra("res2", 19)
            intent.putExtra("res3", 21)
            startActivityForResult(intent, 0)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == RESULT_OK) {
            val res = data?.getIntExtra("resposta", -1)

            when (res) {
                1 -> alert("Questão 1 certa!", "Resposta certa", this)
                else -> alert("Questão 1 errada!", "Resposta errada, tente novamente", this)
            }

        }
    }
}