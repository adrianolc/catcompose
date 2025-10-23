package com.example.catcompose.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.navigation.DetailsRouteEntry
import com.example.catcompose.features.list.navigation.ListRoute
import com.example.catcompose.features.list.navigation.ListRouteEntry

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
        entryProvider =
            entryProvider {
                entry<ListRoute> {
                    ListRouteEntry { catId ->
                        backStack.add(DetailsRoute(catId))
                    }
                }
                entry<DetailsRoute> { key ->
                    DetailsRouteEntry(key) {
                        backStack.removeLastOrNull()
                    }
                }
            },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                slideOutHorizontally(targetOffsetX = { it })
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                slideOutHorizontally(targetOffsetX = { it })
        },
    )
}
