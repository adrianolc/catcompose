package com.example.catcompose.features.details.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class BreedResponse(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("temperament")
    val temperament: String,
    @SerialName("description")
    val description: String,
    @SerialName("origin")
    val origin: String,
    @SerialName("adaptability")
    val adaptability: Int,
    @SerialName("affection_level")
    val affectionLevel: Int,
    @SerialName("child_friendly")
    val childFriendly: Int,
    @SerialName("grooming")
    val grooming: Int,
    @SerialName("energy_level")
    val energyLevel: Int,
    @SerialName("wikipedia_url")
    val wikipediaUrl: String,
)
