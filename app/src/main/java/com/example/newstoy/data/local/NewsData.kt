package com.example.newstoy.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_data")
data class NewsData(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "data_index")
    val index: Int,

    @SerializedName("author")
    @ColumnInfo(name = "author")
    val author: String?,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String?,

    @SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String,

    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?,

    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,

    @SerializedName("content")
    @ColumnInfo(name = "content")
    val content: String?
)