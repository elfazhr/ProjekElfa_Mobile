package com.example.projekelfa_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class activity_about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        btn_kembali.setOnClickListener{
            onBackPressed()
        }
        btn_keprofil.setOnClickListener{
            startActivity(Intent(this@activity_about, activity_profil::class.java))
        }
        btnLoc.setOnClickListener {
            startActivity(Intent(this@activity_about, Maps::class.java))
        }
    }
}