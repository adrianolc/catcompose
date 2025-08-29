package com.example.catcompose.features.list.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ListService {
    @GET("/v1/images/search")
    suspend fun getCats(@Query("limit") limit: Int): List<CatResponse>
}
