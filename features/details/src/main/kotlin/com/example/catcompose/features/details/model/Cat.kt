package com.example.catcompose.features.details.model

internal data class Cat(
    val id: String,
    val imageUrl: String,
    val name: String,
    val breed: Breed?,
)
