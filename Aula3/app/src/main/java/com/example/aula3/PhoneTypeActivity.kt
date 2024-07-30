package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class PhoneTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_type)

        val btnConfirm = findViewById<Button>(R.id.btnConfirmPhone)
        val editName = findViewById<EditText>(R.id.editNamePhone)
        val editPhone = findViewById<EditText>(R.id.editPhoneType)
        val spTipoTel = findViewById<Spinner>(R.id.spTipoTel)

        loadSpinner(spTipoTel)

        btnConfirm.setOnClickListener {

            if(validateFields(editName, editPhone, spTipoTel)) {
                val msg = """Nome: ${editName.text}
                    |Telefone: ${editPhone.text}
                    |
                    |Tipo de telefone
                    |- ${spTipoTel.selectedItem}
                """.trimMargin()

                alert("Confirmado!", msg, this)
            } else {
                alert("Erro!", "Preencha todos os campos!", this)
            }
        }
    }

    private fun validateFields(editName: EditText, editPhone: EditText, spTipoTel: Spinner) : Boolean = (editName.text.isNotEmpty()
            && editPhone.text.isNotEmpty()
            && spTipoTel.selectedItemPosition != 0)

    private fun loadSpinner(spinner: Spinner) {

        val items = arrayOf("Selecione", "Residencial", "Comercial", "Celular", "Outros")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

    }
}