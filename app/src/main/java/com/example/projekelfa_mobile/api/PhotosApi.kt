package com.example.projekelfa_mobile.api

import com.example.projekelfa_mobile.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {
    @GET("data")
    fun getPhotos(): Single<List<Photo>>
}