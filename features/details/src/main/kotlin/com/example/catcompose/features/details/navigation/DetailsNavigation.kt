package com.example.catcompose.features.details.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.details.ui.DetailScreen
import com.example.catcompose.features.details.ui.DetailsViewModel
import kotlinx.serialization.Serializable

@Serializable
public data class DetailsRoute(
    val catId: String,
    val imageUrl: String,
    val catName: String,
) : NavKey

public fun EntryProviderScope<NavKey>.detailsRouteEntry(onBackClick: () -> Unit) {
    entry<DetailsRoute> { key ->
        val detailsViewModel: DetailsViewModel =
            hiltViewModel<DetailsViewModel, DetailsViewModel.Factory>(
                creationCallback = { factory ->
                    factory.create(key)
                },
            )

        DetailScreen(
            onBackClick = onBackClick,
            viewModel = detailsViewModel,
        )
    }
}
