package com.example.catcompose.features.list.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class BreedResponse(
    @SerialName("name")
    val name: String,
)
