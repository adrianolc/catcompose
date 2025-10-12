package com.example.catcompose.features.list.api

import retrofit2.http.GET
import retrofit2.http.Query

internal interface ListService {
    @GET("/v1/images/search")
    suspend fun getCats(
        @Query("limit") limit: Int,
        @Query("has_breeds") hasBreeds: Boolean = true,
    ): List<CatResponse>
}
