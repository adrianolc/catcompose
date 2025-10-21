package com.example.catcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.navigation.detailsRouteEntry
import com.example.catcompose.features.list.navigation.ListRoute
import com.example.catcompose.features.list.navigation.listRouteEntry

@Composable
fun CatNavDisplay(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(ListRoute)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators =
            listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
        entryProvider = { key ->
            when (key) {
                is ListRoute ->
                    listRouteEntry(key) { catId ->
                        backStack.add(DetailsRoute(catId))
                    }
                is DetailsRoute ->
                    detailsRouteEntry(key) {
                        backStack.removeLastOrNull()
                    }
                else -> throw RuntimeException("Unknown key")
            }
        },
    )
}
