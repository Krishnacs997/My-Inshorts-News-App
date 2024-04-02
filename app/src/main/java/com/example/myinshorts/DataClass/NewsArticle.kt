package com.example.myinshorts.DataClass



data class NetworkResponse<T>(

    val success: Boolean,
    val data: T?,
    val errorCode: Int?,
    val message: String?,
    val unConfirmedPaymentID: String?
)

data class NetworkResponseArray<T>(
    val success: Boolean,
    val data: ArrayList<T>?,
    val errorCode: Int?,
    val message: String?
)

data class NewsArticle(
    var status: String = "",
    var totalResults : Int = 0,
    var articles: ArrayList<NewsArticlesList>
)

data class NewsArticlesList(
    var author : String = "",
    var title : String,
    var description : String,
    var url : String,
    var urlToImage: String,
    var publishedAt : String,
    var content : String
)

data class Source(
    val id : String,
    val name : String
)

