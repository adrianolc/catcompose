package com.example.catcompose.features.list.repo

import com.example.catcompose.core.network.asResult
import com.example.catcompose.features.list.api.ListService
import com.example.catcompose.features.list.ui.Cat
import javax.inject.Inject

internal class ListRepository
    @Inject
    constructor(
        private val listService: ListService,
    ) {
        suspend fun getCats(): Result<List<Cat>> =
            asResult {
                listService.getCats(10).map { catResponse ->
                    Cat(
                        id = catResponse.id,
                        imageUrl = catResponse.url,
                        name = catResponse.breeds.first().name,
                    )
                }
            }
    }
