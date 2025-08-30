package com.example.catcompose.features.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.catcompose.features.list.ui.ListScreen
import kotlinx.serialization.Serializable

@Serializable object ListRoute

fun NavGraphBuilder.listScreen() {
    composable<ListRoute> {
        ListScreen()
    }
}
