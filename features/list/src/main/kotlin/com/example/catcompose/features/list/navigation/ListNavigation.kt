package com.example.catcompose.features.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.list.ui.ListScreen
import kotlinx.serialization.Serializable

@Serializable
public object ListRoute

@Serializable
public data object ListRouteNavKey : NavKey

public typealias OnCatClick = (String) -> Unit

public fun NavGraphBuilder.listScreen(onCatClick: OnCatClick) {
    composable<ListRoute> {
        ListScreen(onCatClick)
    }
}

public fun listRouteEntry(
    key: ListRouteNavKey,
    onCatClick: OnCatClick,
): NavEntry<NavKey> =
    NavEntry(
        key = key,
    ) {
        ListScreen(onCatClick)
    }
