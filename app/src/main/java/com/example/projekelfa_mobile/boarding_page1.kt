package com.example.projekelfa_mobile
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.view.View


class boarding_page1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.boarding_page1)

    }

    fun satu(view: View?) {
        val i = Intent(applicationContext, boarding2_page::class.java)
        startActivity(i)

    }
}