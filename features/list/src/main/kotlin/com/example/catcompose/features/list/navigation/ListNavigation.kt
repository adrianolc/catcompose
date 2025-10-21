package com.example.catcompose.features.list.navigation

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.list.ui.ListScreen
import kotlinx.serialization.Serializable

@Serializable
public data object ListRouteNavKey : NavKey

public typealias OnCatClick = (String) -> Unit

public fun listRouteEntry(
    key: ListRouteNavKey,
    onCatClick: OnCatClick,
): NavEntry<NavKey> =
    NavEntry(
        key = key,
    ) {
        ListScreen(onCatClick)
    }
