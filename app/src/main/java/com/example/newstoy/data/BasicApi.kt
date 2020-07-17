package com.example.newstoy.data

import com.example.newstoy.data.remote.QueryData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 *  CRUD 오퍼레이션을 위한 API class
 *
 */
interface BasicApi {

    @GET("json/{id}.json")
    fun loadPlace( @Path("id") id: Int): Observable<QueryData>

    @GET("event/getEvents")
    fun testQuery(): Observable<QueryData>
}