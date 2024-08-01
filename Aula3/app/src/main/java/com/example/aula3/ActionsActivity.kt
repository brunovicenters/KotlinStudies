package com.example.aula3

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import com.example.aula3.databinding.ActivityActionsBinding

class ActionsActivity : AppCompatActivity() {

    lateinit var binding : ActivityActionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActionsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnNavegador.setOnClickListener {
            // Opens a browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.inputURL.text.toString()))
            startActivity(intent)
        }

        val launcherFoto = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val img: Bitmap? = it.data?.getParcelableExtra("data")
                binding.imgFoto.setImageBitmap(img)
            }
        }

        binding.btnFoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            // Verifies if activity exists
            if (intent.resolveActivity(packageManager) != null) {
                // New way
                launcherFoto.launch(intent)
                // Old way
//              startActivityForResult(intent, 0)
            }
        }

        binding.btnAlarme.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM)

            intent.putExtra(AlarmClock.EXTRA_HOUR, 10)
            intent.putExtra(AlarmClock.EXTRA_MINUTES, 30)
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarme de teste")

            startActivity(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode == RESULT_OK) {
//            if (requestCode == 0) {
//                val img: Bitmap? = data?.getParcelableExtra("data")
//                binding.imgFoto.setImageBitmap(img)
//            }
//        }
//    }
}