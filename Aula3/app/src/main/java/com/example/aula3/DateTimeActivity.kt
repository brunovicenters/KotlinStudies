package com.example.aula3

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityDateTimeBinding

class DateTimeActivity : AppCompatActivity() {

   lateinit var binding: ActivityDateTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDateTimeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        binding.imgDate.setOnClickListener {
            DatePickerDialog(this, { calView, sYear, sMonth, sDay ->
                binding.etDate.setText("$sDay/${sMonth + 1}/$sYear")

            }, year, month, day).show()
        }

        binding.btnSet.setOnClickListener {

        }


    }
}