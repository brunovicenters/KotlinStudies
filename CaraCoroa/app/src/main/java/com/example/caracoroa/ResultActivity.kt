package com.example.caracoroa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.caracoroa.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        val opt: List<String> = listOf("cara", "coroa")

        val computerOpt = opt.random()

        val nome = intent.getStringExtra("player")
        val choice = intent.getStringExtra("choice").toString()

        val res = validateResult(computerOpt, choice)

        when(res){
            "ganhou" -> {
                binding.txtComputer.text = "A moeda caiu $computerOpt"
                binding.txtResult.text = "$nome ganhou!"
            }
            "perdeu" -> {
                binding.txtComputer.text = "A moeda caiu $computerOpt"
                binding.txtResult.text = "$nome perdeu!"
            }
            else -> {
                binding.txtComputer.text = "Resposta inválida!"
                binding.txtResult.text = "Tente novamente"
            }
        }
    }

    fun validateResult(cpOp:String, playerOp:String) : String {
        var res = "";
        if (cpOp == playerOp) {
            res = "ganhou"
        } else if (cpOp != playerOp && (playerOp == "cara" || playerOp == "coroa")) {
            res = "perdeu"
        } else {
            res = "invalido"
        }
        return res
    }
}