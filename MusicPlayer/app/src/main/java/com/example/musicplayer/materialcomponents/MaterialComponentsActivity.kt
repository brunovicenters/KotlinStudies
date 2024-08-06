package com.example.musicplayer.materialcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ActivityMaterialComponentsBinding
import com.google.android.material.snackbar.Snackbar

class MaterialComponentsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMaterialComponentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            if (binding.editSobrenome.text.isNullOrEmpty()) {
                binding.editSobrenomeInputLayout.error = "Preencha o campo"
                binding.editSobrenome.requestFocus()
            } else {
                binding.editSobrenomeInputLayout.isErrorEnabled = false
                Snackbar.make(it, "Preenchido", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.editSobrenome.doOnTextChanged { text, start, before, count ->
            binding.editSobrenomeInputLayout.isErrorEnabled = false
        }

        chipSelected(binding.chip1)
        chipSelected(binding.chip2)
        chipSelected(binding.chip3)
    }

    fun chipSelected(chip: com.google.android.material.chip.Chip) {
        chip.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                Snackbar.make(chip, "Chip selecionado: ${chip.text}", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}