package com.example.catcompose.features.details.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.details.ui.DetailScreen
import com.example.catcompose.features.details.ui.DetailsViewModel
import kotlinx.serialization.Serializable

@Serializable
public data class DetailsRoute(
    val catId: String,
) : NavKey

public fun detailsRouteEntry(
    key: DetailsRoute,
    onBackClick: () -> Unit,
): NavEntry<NavKey> =
    NavEntry(
        key = key,
    ) {
        val detailsViewModel: DetailsViewModel =
            hiltViewModel<DetailsViewModel, DetailsViewModel.Factory>(
                creationCallback = { factory ->
                    factory.create(key.catId)
                },
            )

        DetailScreen(
            onBackClick = onBackClick,
            viewModel = detailsViewModel,
        )
    }
