package com.example.tugas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvNIM: TextView = findViewById(R.id.tvNIM)
        val tvNama: TextView = findViewById(R.id.tvNama)
        val tvHasil: TextView = findViewById(R.id.tvHasil)

        val intent = intent
        val nim = intent.getStringExtra("NIM")
        val nama = intent.getStringExtra("NAMA")
        val hasil = intent.getStringExtra("HASIL")

        tvNIM.text = "NIM: $nim"
        tvNama.text = "Nama: $nama"
        tvHasil.text = "Hasil: $hasil"
    }
}