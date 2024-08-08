package com.example.vycenotes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vycenotes.databinding.ActivityUserBinding
import com.google.android.material.snackbar.Snackbar

class UserActivity : AppCompatActivity() {
    
    lateinit var binding : ActivityUserBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userPref = getSharedPreferences("user_vnotes", Context.MODE_PRIVATE)

        val username = userPref.getString("user", "")

        binding.etUsername.setText(username)

        binding.btnSave.setOnClickListener {
            val editUser = userPref.edit()
            editUser.putString("user", binding.etUsername.text.toString())

            editUser.commit()

            Snackbar.make(it, "Usuário salvo!", Snackbar.LENGTH_SHORT).show()
        }
    }
}