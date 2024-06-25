package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editMsg = findViewById<EditText>(R.id.editMsg)
        val btnIr = findViewById<Button>(R.id.btnIr)

        btnIr.setOnClickListener {
            editMsg.setText("Hello Kotlin")
        }
    }
}