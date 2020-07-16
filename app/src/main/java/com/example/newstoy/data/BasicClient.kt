package com.example.newstoy.data

import com.example.newstoy.di.component.DaggerApiComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * REST API 통신을 위한 Client
 *
 * - Dagger2 연습을 위한 부분적 Component 활용
 */
class BasicClient {
    fun getApi(): BasicApi = Retrofit.Builder()
        .baseUrl(DaggerApiComponent.create().getApiKey())
        .client(OkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BasicApi::class.java)
}