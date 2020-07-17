package com.example.newstoy.data.remote

import com.example.newstoy.data.local.NewsData
import com.google.gson.annotations.SerializedName

/**
 *  NEWS API 로부터 받은 Response 클래스
 */
data class QueryData(

    @SerializedName("status")
    val status: String,

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articles: List<NewsData>
)