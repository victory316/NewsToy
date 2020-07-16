package com.example.newstoy.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsData(

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    val id : Int
) {
}