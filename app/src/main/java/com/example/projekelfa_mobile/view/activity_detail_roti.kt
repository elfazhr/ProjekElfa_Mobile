package com.example.projekelfa_mobile.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.projekelfa_mobile.R
import com.example.projekelfa_mobile.activity_profil
import com.example.projekelfa_mobile.boarding_page1
import com.example.projekelfa_mobile.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_list_detail_retrofit.*
import kotlinx.android.synthetic.main.activity_roti.*

class activity_detail_roti : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail_retrofit)
        nama_roti_detail.text = intent.getStringExtra("nama_roti")
        nama_roti_detail2.text = intent.getStringExtra("nama_roti")
        harga_roti_detail.text = intent.getStringExtra("harga_roti")
        detail_roti.text = intent.getStringExtra("detail")

        Glide.with(this)
            .load(intent.getStringExtra("gambar"))
            .into(gambar_roti_detail)
    }

    fun backsz(view: View?) {
        onBackPressed()
    }
    fun profilsz(view: View?) {
        val i = Intent(applicationContext, activity_profil::class.java)
        startActivity(i)

    }

}