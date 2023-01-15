package com.example.projekelfa_mobile.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projekelfa_mobile.R
import com.example.projekelfa_mobile.model.Photo
import kotlinx.android.synthetic.main.activity_list_detail_retrofit.view.*
import kotlinx.android.synthetic.main.activity_list_roti.view.*

class PhotoListAdapter (var photos: ArrayList<Photo>) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_list_roti,parent,false)
    )
    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){

        holder.bind(photos[position])
    }
    class  ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo) {
            val gambar : ImageView =itemView.gambar_roti
            itemView.nama_roti.text = photos.title
            itemView.harga_roti.text = photos.harga.toString()
//            Log.e("err",photos.rating)
            itemView.desc_roti.text = photos.keterangan
            val detail = photos.detail
            val judul = photos.title.toString()
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, activity_detail_roti::class.java)
                intent.putExtra("nama_roti",photos.title)
                intent.putExtra("harga_roti",photos.harga)
                intent.putExtra("detail",photos.detail)
                intent.putExtra("gambar",photos.thumbnail)
                itemView.context.startActivity(intent)
            }
            val urGambar=photos.thumbnail.toString().filterNot { it.isWhitespace() }

            Glide.with(itemView.context)
                .load("$urGambar")
                .into(gambar)
//            Glide.with(itemView.context).load(photos.thumbnail).into(itemView.imageView)
        }
    }
}