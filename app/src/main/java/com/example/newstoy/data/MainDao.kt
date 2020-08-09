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

    @Query("DELETE FROM news_data")
    fun deleteNews()

    @Query("SELECT * FROM news_data WHERE data_index == :id ")
    fun getNewsWithId(id: Int): LiveData<NewsData>

    @Query("SELECT * FROM news_data WHERE data_index == :id ")
    fun getNewsWithIdTest(id: Int): NewsData
}