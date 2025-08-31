package com.example.catcompose.features.details.api

import retrofit2.http.GET
import retrofit2.http.Path

internal interface DetailsService {
    @GET("/v1/images/{id}")
    suspend fun getCat(@Path("id") id: String): CatResponse
}