package com.ptit.retrofit_example

import com.ptit.retrofit_example.model.Photo
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("/photos")
    fun getAllPhotos(): Call<List<Photo>>
}
