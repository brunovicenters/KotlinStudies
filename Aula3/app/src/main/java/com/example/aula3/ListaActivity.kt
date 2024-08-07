package com.example.aula3

import android.content.Intent
import android.graphics.Color
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

        binding.btnQuestao2.setOnClickListener {
            val intent = Intent(this, QuestaoActivity::class.java)
            intent.putExtra("enunciado", "Quantos irmãos eu(Bruno Vicente) tenho?")
            intent.putExtra("res1", 0)
            intent.putExtra("res2", 4)
            intent.putExtra("res3", 1)
            startActivityForResult(intent, 1)
        }

        binding.btnQuestao3.setOnClickListener {
            val intent = Intent(this, QuestaoStringActivity::class.java)
            intent.putExtra("enunciado", "Qual é a mulher mais linda do mundo?")
            intent.putExtra("res1", "Dua Lipa")
            intent.putExtra("res2", "Tarsila Carvalho dos Reis")
            intent.putExtra("res3", "Minha vovó")
            startActivityForResult(intent, 2)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {

            when (requestCode) {
                0 -> {
                    val res = data?.getIntExtra("resposta", -1)

                    val label = data?.getIntExtra("label", -1)

                    when (res) {
                        1 -> {
                            alert("Questão 1 certa!", "Resposta está certa! É mesmo $label", this)
                            binding.btnQuestao1.setBackgroundColor(Color.GREEN)
                            binding.btnQuestao1.isEnabled = false
                            binding.btnQuestao1.text = ("Certo!")
                            binding.btnQuestao1.setTextColor(Color.BLACK)
                        }
                        else -> {
                            alert("Questão 1 errada!", "Resposta errada, tente novamente", this)
                            binding.btnQuestao1.setBackgroundColor(Color.RED)
                        }
                    }
                }
                1 -> {
                    val res = data?.getIntExtra("resposta", -1)

                    val label = data?.getIntExtra("label", -1)

                    when (res) {
                        2 -> {
                            alert("Questão 2 certa!", "Resposta está certa! É mesmo $label", this)
                            binding.btnQuestao2.setBackgroundColor(Color.GREEN)
                            binding.btnQuestao2.isEnabled = false
                            binding.btnQuestao2.text = ("Certo!")
                            binding.btnQuestao2.setTextColor(Color.BLACK)
                        }
                        else -> {
                            alert("Questão 2 errada!", "Resposta errada, tente novamente", this)
                            binding.btnQuestao2.setBackgroundColor(Color.RED)
                        }
                    }
                }
                2 -> {
                    val res = data?.getIntExtra("resposta", -1)

                    val label = data?.getStringExtra("label")

                    when (res) {
                        1 -> {
                            alert("Questão 3 certa!", "Resposta está certa! É mesmo $label", this)
                            binding.btnQuestao3.setBackgroundColor(Color.GREEN)
                            binding.btnQuestao3.isEnabled = false
                            binding.btnQuestao3.text = ("Certo!")
                            binding.btnQuestao3.setTextColor(Color.BLACK)
                        }
                        else -> {
                            alert("Questão 3 errada!", "Resposta errada, tente novamente", this)
                            binding.btnQuestao3.setBackgroundColor(Color.RED)
                        }
                    }

                }
                else -> {
                    alert("Questão inexistente!", "Tente uma questão existente", this)
                }
            }
        }
    }
}