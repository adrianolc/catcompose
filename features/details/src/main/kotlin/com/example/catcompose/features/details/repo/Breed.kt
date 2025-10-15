package com.example.catcompose.features.details.repo

internal data class Breed(
    val id: String,
    val name: String,
    val temperament: String,
    val description: String,
    val origin: String,
    val adaptability: Int,
    val affectionLevel: Int,
    val childFriendly: Int,
    val grooming: Int,
    val energyLevel: Int,
    val wikipediaUrl: String,
)
