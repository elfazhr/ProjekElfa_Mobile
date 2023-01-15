package com.example.projekelfa_mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekelfa_mobile.R
import com.example.projekelfa_mobile.activity_profil
import com.example.projekelfa_mobile.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_roti.*

class activity_roti : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roti)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
        menuju_back.setOnClickListener{
            onBackPressed()
        }
        menuju_profil.setOnClickListener{
            startActivity(Intent(this@activity_roti, activity_profil::class.java))
        }
    }

    fun observeViewModel() {
        viewModel.photos.observe(this, Observer { photos ->
            photos?.let {
                photoListAdapter.updatePhotos(it)
            }
        })
    }
}