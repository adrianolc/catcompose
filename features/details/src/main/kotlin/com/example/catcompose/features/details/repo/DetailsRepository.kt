package com.example.catcompose.features.details.repo

import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.core.network.asNetworkResult
import com.example.catcompose.features.details.api.BreedResponse
import com.example.catcompose.features.details.api.CatResponse
import com.example.catcompose.features.details.api.DetailsService
import com.example.catcompose.features.details.model.Breed
import com.example.catcompose.features.details.model.Cat
import javax.inject.Inject
import kotlin.String

internal class DetailsRepository
    @Inject
    constructor(
        private val detailsService: DetailsService,
    ) {
        suspend fun getCat(id: String): NetworkResult<Cat> =
            asNetworkResult {
                detailsService.getCat(id).toCat()
            }
    }

private fun CatResponse.toCat(): Cat =
    Cat(
        id = id,
        url = url,
        breed = breeds.first().toBreed(),
    )

private fun BreedResponse.toBreed(): Breed =
    Breed(
        id = id,
        name = name,
        temperament = temperament.split(","),
        description = description,
        origin = origin,
        adaptability = adaptability,
        affectionLevel = affectionLevel,
        childFriendly = childFriendly,
        grooming = grooming,
        energyLevel = energyLevel,
        wikipediaUrl = wikipediaUrl,
    )
