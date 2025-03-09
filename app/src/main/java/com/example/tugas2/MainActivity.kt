package com.example.tugas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etAngka1: EditText = findViewById(R.id.etAngka1)
        val etAngka2: EditText = findViewById(R.id.etAngka2)
        val rgOperasi: RadioGroup = findViewById(R.id.rgOperasi)
        val btnHitung: Button = findViewById(R.id.btnHitung)

        btnHitung.setOnClickListener {
            val angka1 = etAngka1.text.toString().toDoubleOrNull()
            val angka2 = etAngka2.text.toString().toDoubleOrNull()

            if (angka1 == null || angka2 == null) {
                Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButtonId = rgOperasi.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih operasi terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
            val operasi = selectedRadioButton.text.toString()

            val hasil = when (operasi) {
                "+" -> angka1 + angka2
                "-" -> angka1 - angka2
                "*" -> angka1 * angka2
                "/" -> angka1 / angka2
                else -> 0.0
            }

            val nim = "235150701111038" // Ganti dengan NIM Anda
            val nama = "Acik Imtia Chana" // Ganti dengan nama Anda

            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("NIM", nim)
            intent.putExtra("NAMA", nama)
            intent.putExtra("HASIL", hasil.toString())
            startActivity(intent)
        }
    }
}