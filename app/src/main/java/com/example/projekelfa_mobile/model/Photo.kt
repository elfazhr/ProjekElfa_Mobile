package com.example.projekelfa_mobile.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("judul")
    val title: String?,
    @SerializedName("gambar_roti")
    val thumbnail: String?,
    @SerializedName("keterangan")
    val keterangan: String?,
    @SerializedName("harga")
    val harga: String?,
    @SerializedName("detail")
    val detail: String?
)