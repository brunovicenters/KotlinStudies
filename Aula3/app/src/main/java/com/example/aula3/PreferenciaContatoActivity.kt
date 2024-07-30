package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class PreferenciaContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencia_contato)

        val editNome = findViewById<EditText>(R.id.editNome)
        val editTel = findViewById<EditText>(R.id.editTel)
        val editEmail = findViewById<EditText>(R.id.editEmail)

        val checkBoxEmail = findViewById<CheckBox>(R.id.checkEmail)
        val checkBoxTel = findViewById<CheckBox>(R.id.checkTel)

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarPref)

        btnCadastrar.setOnClickListener {
            // Raw String
            var msg: String = """Nome: ${editNome.text}
                |Telefone: ${editTel.text}
                |Email: ${editEmail.text}
                |
                |Preferência de Contato 
            """.trimMargin()

            if(checkBoxTel.isChecked) msg += "\n- Telefone"

            if(checkBoxEmail.isChecked) msg += "\n- Email"

            alert("Cadastro concluído!", msg, this)
        }
    }
}