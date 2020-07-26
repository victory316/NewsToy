package com.example.newstoy.di.module

import android.app.Application
import android.content.Context
import com.example.newstoy.App
import com.example.newstoy.data.BasicApi
import com.example.newstoy.data.BasicClient
import com.example.newstoy.data.MainDao
import com.example.newstoy.data.MainRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ RetrofitModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideAppContext(app: App): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApplication(app: App): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMainRepository(dao: MainDao): MainRepository {
        return MainRepository.getInstance(dao)
    }

//    @Provides
//    @Singleton
//    fun provideAppDatabase(context: Context): AppDatabase {
//        return Room
//            .inMemoryDatabaseBuilder(context, AppDatabase::class.java) // temporary
////                .databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME) // permanent
//            .fallbackToDestructiveMigration()
//            .addCallback(object : RoomDatabase.Callback(){
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    super.onCreate(db)
//                    for( index in 0 until 10000){
//                        val cv = ContentValues()
//                        cv.put("name", "Name$index")
//                        cv.put("birth", "$index")
//                        db.insert("person", SQLiteDatabase.CONFLICT_REPLACE,cv)
//                    }
//                }
//            })
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideApiHelper(): ApiHelper = Retrofit.Builder()
//        .baseUrl("https://jsonplaceholder.typicode.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(ApiHelper::class.java)
//
//    @Provides
//    @Singleton
//    fun providePersonDao(appDatabase: AppDatabase): UserDao {
//        return appDatabase.dao()
//    }
//
//    @Provides
//    @Singleton
//    fun providePreferencesHelper(context:Context): PreferencesHelper {
//        return PreferencesHelperImpl(context, AppConstants.PREF_NAME)
//    }
//
//    @Provides
//    @Singleton
//    fun providePhotoHelper(): PhotoHelper {
//        return PhotoHelperImpl()
//    }


    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }
}