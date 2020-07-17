package com.example.newstoy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newstoy.data.local.NewsData

/**
 *  Room database
 */
@Database(entities = [NewsData::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getMainDao(): MainDao

    companion object {
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase? {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MainDatabase::class.java, "main_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}