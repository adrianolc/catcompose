package com.example.catcompose.features.details.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.details.ui.DetailScreen
import com.example.catcompose.features.details.ui.DetailsViewModel
import kotlinx.serialization.Serializable

@Serializable
public data class DetailsRoute(
    val catId: String,
) : NavKey

@Composable
public fun DetailsRouteEntry(
    key: DetailsRoute,
    onBackClick: () -> Unit,
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
