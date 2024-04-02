package com.example.myinshorts.network

import android.app.Application
import com.example.myinshorts.DataClass.NetworkResponse
import com.example.myinshorts.DataClass.NetworkResponseArray
import com.example.myinshorts.DataClass.NewsArticle
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface RestApiService {

    @GET("/v2/top-headlines")
    suspend  fun getNews(@Query("country") country : String, @Query("category") category : String?, @Query("apiKey") key : String): Response<NewsArticle>

    companion object {
        fun create(application: Application): RestApiService {
            val okHttpBuilder = OkHttpClient.Builder()

            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .build()

            return retrofit.create(RestApiService::class.java)
        }
    }

}