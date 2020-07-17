package com.example.newstoy.data

import com.example.newstoy.data.remote.QueryData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *  CRUD 오퍼레이션을 위한 API class
 *
 */
interface BasicApi {

    @GET("json/{id}.json")
    fun loadPlace(@Path("id") id: Int): Observable<QueryData>

    @GET("top-headlines")
    fun testQuery(
        @Query("country") country: String,
        @Query("apiKey") key: String
    ): Observable<QueryData>
}