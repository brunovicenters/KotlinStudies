package com.example.aula3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityDateTimeBinding
import java.sql.Time

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
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)

        binding.imgDate.setOnClickListener {
            DatePickerDialog(this, { calView, sYear, sMonth, sDay ->
                binding.etDate.setText("$sDay/${sMonth + 1}/$sYear")
            }, year, month, day).show()
        }

        binding.imgTime.setOnClickListener {

            TimePickerDialog(this, { timeView, sHour, sMinute ->
                val tdHour = sHour.toString().padStart(2, '0')
                val tdMinutes = sMinute.toString().padStart(2, '0')
                binding.etTime.setText("$tdHour:$tdMinutes")
            }, hour, minute, true).show()

        }

        binding.btnSet.setOnClickListener {
            val msg = """
                |Data: ${binding.etDate.text}
                |
                |Hora: ${binding.etTime.text}
                """.trimMargin()

            alert("Data e Hora", msg, this)
        }

    }
}