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
                val msg = """${getString(R.string.phone_name)}: ${editName.text}
                    |${getString(R.string.phone_number_input)}: ${editPhone.text}
                    |
                    |${getString(R.string.phone_type)}
                    |- ${spTipoTel.selectedItem}
                """.trimMargin()

                alert(getString(R.string.confirmed), msg, this)
            } else {
                alert(getString(R.string.error), getString(R.string.fill_all_fields), this)
            }
        }
    }

    private fun validateFields(editName: EditText, editPhone: EditText, spTipoTel: Spinner) : Boolean = (editName.text.isNotEmpty()
            && editPhone.text.isNotEmpty()
            && spTipoTel.selectedItemPosition != 0)

    private fun loadSpinner(spinner: Spinner) {

        val items = arrayOf(getString(R.string.select), getString(R.string.home), getString(R.string.business), getString(R.string.mobile), getString(R.string.others))

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

    }
}