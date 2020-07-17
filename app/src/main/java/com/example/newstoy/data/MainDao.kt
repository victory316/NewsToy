package com.example.newstoy.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.newstoy.data.remote.ArticlesData
import com.example.newstoy.data.remote.NewsData

/**
 * Room과의 Transaction을 위한 Dao interface
 */
@Dao
interface MainDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertNews(news: NewsData)
}