package com.example.newstoy.data.remote

import com.google.gson.annotations.SerializedName

data class ArticlesData (

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("page")
    val page: Int,

    @SerializedName("counts")
    val counts: Int,

    @SerializedName("pages")
    val pages: Int
)