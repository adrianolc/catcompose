package com.example.catcompose.features.details.navigation

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.details.ui.DetailScreen
import kotlinx.serialization.Serializable

@Serializable
public data class DetailsRouteNavKey(
    val catId: String,
) : NavKey

public fun detailsRouteEntry(
    key: DetailsRouteNavKey,
    onBackClick: () -> Unit,
): NavEntry<NavKey> =
    NavEntry(
        key = key,
    ) {
        DetailScreen(onBackClick)
    }
