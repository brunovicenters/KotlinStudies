package com.example.aula3

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class ExemploPronomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemplo_pronome)

        val editNome = findViewById<EditText>(R.id.editNome)
        val groupPronomes = findViewById<RadioGroup>(R.id.groupPronomes)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        if(intent.hasExtra("nome")) {
            editNome.setText(intent.getStringExtra("nome"))
        }

        btnCadastrar.setOnClickListener {
            val nome = editNome.text.toString()
            var pronome: String = when (groupPronomes.checkedRadioButtonId) {
                R.id.radioEle -> "Ele/Dele"
                R.id.radioEla -> "Ela/Dela"
                R.id.radioNeutro -> {
                    "Elu/Delu"
                }
                else -> "You didn't choose anything"
            }
            alert("Cadastrado com sucesso!", "Olá, $nome, você escolheu os pronomes $pronome", this)
        }
    }
}