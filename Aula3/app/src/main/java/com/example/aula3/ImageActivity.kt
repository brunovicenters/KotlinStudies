package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgView.setImageResource(R.drawable.apple)
        binding.imgView.tag = R.drawable.apple

        binding.btnImg.setOnClickListener {

            when (binding.imgView.tag) {
                R.drawable.apple -> {
                    binding.imgView.setImageResource(R.drawable.orange)
                    binding.imgView.tag = R.drawable.orange
                }
                R.drawable.orange -> {
                    binding.imgView.setImageResource(R.drawable.pineapple)
                    binding.imgView.tag = R.drawable.pineapple
                }
                R.drawable.pineapple -> {
                    binding.imgView.setImageResource(R.drawable.apple)
                    binding.imgView.tag = R.drawable.apple
                }
                else -> binding.imgView.setImageResource(R.drawable.apple)
            }

        }

    }
}