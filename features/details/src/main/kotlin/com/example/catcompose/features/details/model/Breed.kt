package com.example.catcompose.features.details.model

internal data class Breed(
    val temperament: List<String>,
    val description: String,
    val origin: String,
    val adaptability: Int,
    val affectionLevel: Int,
    val childFriendly: Int,
    val grooming: Int,
    val energyLevel: Int,
    val wikipediaUrl: String,
)
