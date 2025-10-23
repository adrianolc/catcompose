package com.example.catcompose.features.list.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.list.ui.Cat
import com.example.catcompose.features.list.ui.ListScreen
import kotlinx.serialization.Serializable

@Serializable
public data object ListRoute : NavKey

public typealias OnCatClick = (Cat) -> Unit

@Composable
public fun ListRouteEntry(onCatClick: OnCatClick) {
    ListScreen(onCatClick)
}
