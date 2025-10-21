package com.example.catcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.navigation.DetailsRouteNavKey
import com.example.catcompose.features.details.navigation.detailsRouteEntry
import com.example.catcompose.features.details.navigation.detailsScreen
import com.example.catcompose.features.list.navigation.ListRoute
import com.example.catcompose.features.list.navigation.ListRouteNavKey
import com.example.catcompose.features.list.navigation.listRouteEntry
import com.example.catcompose.features.list.navigation.listScreen

@Composable
fun CatNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = ListRoute,
        modifier = modifier,
    ) {
        listScreen { catId ->
            navController.navigate(route = DetailsRoute.createRoute(catId))
        }
        detailsScreen {
            navController.popBackStack()
        }
    }
}

@Composable
fun CatNavDisplay(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(ListRouteNavKey)

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
                is ListRouteNavKey ->
                    listRouteEntry(key) { catId ->
                        backStack.add(DetailsRouteNavKey(catId))
                    }
                is DetailsRouteNavKey ->
                    detailsRouteEntry(key) {
                        backStack.removeLastOrNull()
                    }
                else -> throw RuntimeException("Unknown key")
            }
        },
    )
}
