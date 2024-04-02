package com.example.myinshorts.Repo

import com.example.myinshorts.DataClass.NewsArticle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    fun getNews(@Query("country") country : String, @Query("category") category : String?, @Query("apiKey") key : String): Call<NewsArticle>

}
