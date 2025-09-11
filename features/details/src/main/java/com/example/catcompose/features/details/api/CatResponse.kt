package com.example.catcompose.features.details.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class CatResponse(
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val url: String,
    @SerialName("breeds")
    val breeds: List<BreedResponse>,
)
