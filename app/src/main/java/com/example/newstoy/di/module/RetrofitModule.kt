package com.example.newstoy.di.module

import com.example.newstoy.data.BasicApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class RetrofitModule {

    @Provides
    @Reusable
    fun providePostService(retrofit: Retrofit): BasicApi {
        return retrofit.create(BasicApi::class.java)
    }
}