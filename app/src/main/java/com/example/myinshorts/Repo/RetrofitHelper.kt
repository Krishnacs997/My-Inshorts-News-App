package com.example.myinshorts.Repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private const val BASE_URL = "https://newsapi.org/v2/"
    fun getInstance(): Retrofit {

        return retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }
}