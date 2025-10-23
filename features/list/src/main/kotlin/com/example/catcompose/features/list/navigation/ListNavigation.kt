package com.example.catcompose.features.list.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.list.ui.Cat
import com.example.catcompose.features.list.ui.ListScreen
import kotlinx.serialization.Serializable

@Serializable
public data object ListRoute : NavKey

public typealias OnCatClick = (Cat) -> Unit

public fun EntryProviderScope<NavKey>.listRouteEntry(onCatClick: OnCatClick) {
    entry<ListRoute> {
        ListScreen(onCatClick)
    }
}
