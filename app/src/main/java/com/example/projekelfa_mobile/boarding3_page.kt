package com.example.projekelfa_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class boarding3_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.boarding_page3)

    }

    fun tiga(view: View?) {
        val i = Intent(applicationContext, activity_login::class.java)
        startActivity(i)

    }
}