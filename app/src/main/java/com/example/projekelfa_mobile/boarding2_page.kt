package com.example.projekelfa_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class boarding2_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.boarding_page2)

    }

    fun dua(view: View?) {
        val i = Intent(applicationContext, boarding3_page::class.java)
        startActivity(i)

    }
}