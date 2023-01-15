package com.example.projekelfa_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sukses_order.*

class activity_sukses_order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sukses_order)

        btnKeHistory.setOnClickListener {
            startActivity(Intent(this@activity_sukses_order, activity_history::class.java))
        }
        keProfil.setOnClickListener{
            startActivity(Intent(this@activity_sukses_order, activity_profil::class.java))
        }
        kembali.setOnClickListener{
            startActivity(Intent(this@activity_sukses_order, activity_utama::class.java))
        }
    }
}