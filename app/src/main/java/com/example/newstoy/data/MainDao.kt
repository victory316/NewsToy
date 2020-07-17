package com.example.newstoy.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newstoy.data.local.NewsData

/**
 * Room과의 Transaction을 위한 Dao interface
 */
@Dao
interface MainDao {

    @Transaction
    open fun insertNewsTransaction(list: List<NewsData>) {
        insertNews(list)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: List<NewsData>)

    @Query("SELECT * FROM news_data")
    fun getNewsList(): LiveData<List<NewsData>>
}