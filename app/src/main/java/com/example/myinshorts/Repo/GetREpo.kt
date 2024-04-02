package com.example.myinshorts.Repo

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.myinshorts.DataClass.NetworkResponse
import com.example.myinshorts.DataClass.NetworkResponseArray
import com.example.myinshorts.DataClass.NewsArticle
import com.example.myinshorts.DataClass.NewsArticlesList
import com.example.myinshorts.network.RestApiService
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class GetREpo(val apiService: RestApiService) {


    suspend fun getNewsData(): Response<NewsArticle> {
        return apiService.getNews("in", "business", "00dbf7a973e84ebab8b80dd6a20cbc26")
    }
/*
    companion object {

        fun getNewsApiCall(): MutableLiveData<ArrayList<NewsArticlesList>> {

            var newsList = MutableLiveData<ArrayList<NewsArticlesList>>()

            var call = RetrofitHelper.getInstance().create(NewsApi::class.java)
                .getNews("in", "business", "5a3e054de1834138a2fbc4a75ee69053")

            call.enqueue(object : Callback<NewsArticle>{
                override fun onResponse(call: Call<NewsArticle>, response: Response<NewsArticle>) {
                    if(response.isSuccessful){
                        val body = response.body()

                        body?.let {
                            var tempNewsList = mutableListOf<NewsArticlesList>()
                            body.articles?.forEach{
                                tempNewsList.add(NewsArticlesList(
                                    it.author ?: "",
                                    it.title,
                                    it.description,
                                    it.url,
                                    it.urlToImage,
                                    it.publishedAt,
                                    it.content
                                ))
                            }

                            newsList.value = tempNewsList as ArrayList<NewsArticlesList>

                        }
                    } else{
                        val jsonObj: JSONObject?

                        try {
                            jsonObj = response.errorBody()?.string()?.let { JSONObject(it) }
                            if (jsonObj != null) {
                                */
/*MainActivity.apiRequestError = true
                                MainActivity.errorMessage = jsonObj.getString("message")*//*

                                val tempNewsList = mutableListOf<NewsArticlesList>()
                                newsList.value = tempNewsList as ArrayList<NewsArticlesList>
                                //Toast.makeText(this@GetREpo, jsonObj, Toast.LENGTH_SHORT).show()
                            }
                        } catch (e: JSONException) {
                            Log.d("JSONException", "" + e.message)
                        }
                    }
                }

                override fun onFailure(call: Call<NewsArticle>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            return newsList
        }

    }
*/

}