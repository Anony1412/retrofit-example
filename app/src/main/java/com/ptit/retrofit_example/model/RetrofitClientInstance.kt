package com.ptit.retrofit_example.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {
        private var instance: Retrofit? = null
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun getInstance(): Retrofit =
            instance ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().also { instance = it }
    }
}
