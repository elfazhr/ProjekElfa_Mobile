package com.example.projekelfa_mobile

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.projekelfa_mobile.databinding.ActivityUtamaBinding
import com.example.projekelfa_mobile.databinding.ItemSlideBinding
import com.example.projekelfa_mobile.view.activity_roti
import kotlinx.android.synthetic.main.activity_profil.*
import kotlinx.android.synthetic.main.activity_utama.*

class activity_utama : AppCompatActivity() {
    private lateinit var binding: ActivityUtamaBinding
    private lateinit var adapter : ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(
            ImageData(
                "https://i.postimg.cc/VsVSfjcZ/item-slide1.png"
            )
        )
        list.add(
            ImageData(
                "https://i.postimg.cc/LsW-X9pcY/item-slider2.png"
            )
        )
        list.add(
            ImageData(
                "https://i.postimg.cc/sXZ21Lzn/item-slider3.png"
            )
        )
        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })
        order()
        profil()
        history()
        about()
        breads()
    }

    private fun breads() {
        bread.setOnClickListener{
            startActivity(Intent(this@activity_utama, activity_roti::class.java))
        }
    }


    private fun about() {
        about.setOnClickListener{
            startActivity(Intent(this@activity_utama, activity_about::class.java))
        }
    }

    private fun history() {
        historiess.setOnClickListener{
            startActivity(Intent(this@activity_utama, activity_history::class.java))
        }
    }

    fun order() {
        order.setOnClickListener {
            startActivity(Intent(this@activity_utama, activity_pesan::class.java))
        }

    }
    fun profil() {
        profil.setOnClickListener {
            startActivity(Intent(this@activity_utama, activity_profil::class.java))
        }

    }

    private fun selectedDot(position: Int) {
        for(i in 0 until list.size){
            if(i ==position)
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.coklat_tua))
            else
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.coklat_muda))
        }
    }

    private fun setIndicator() {
        for(i in 0 until list.size){
            dots.add(TextView(this))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

}