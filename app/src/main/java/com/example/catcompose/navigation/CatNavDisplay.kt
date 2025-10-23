package com.example.catcompose.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.catcompose.core.navigation.Navigator
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.navigation.detailsRouteEntry
import com.example.catcompose.features.list.navigation.listRouteEntry

@Composable
fun CatNavDisplay(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    NavDisplay(
        modifier = modifier,
        backStack = navigator.backStack,
        onBack = { navigator.pop() },
        entryDecorators =
            listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
        entryProvider =
            entryProvider {
                listRouteEntry { cat ->
                    backStack.add(
                        DetailsRoute(
                            catId = cat.id,
                            imageUrl = cat.url,
                            catName = cat.name,
                        ),
                    )
                }
                detailsRouteEntry {
                    backStack.removeLastOrNull()
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
