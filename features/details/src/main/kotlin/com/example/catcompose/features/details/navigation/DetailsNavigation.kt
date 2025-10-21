package com.example.catcompose.features.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.example.catcompose.features.details.ui.DetailScreen
import kotlinx.serialization.Serializable

public object DetailsRoute {
    private const val BASE_ROUTE = "details"
    public const val ARG_CAT_ID: String = "cat_id"

    public fun route(): String = "${BASE_ROUTE}/{${ARG_CAT_ID}}"

    public fun createRoute(id: String): String = "${BASE_ROUTE}/$id"
}

@Serializable
public data class DetailsRouteNavKey(
    val catId: String,
) : NavKey

public fun NavGraphBuilder.detailsScreen(onBackClick: () -> Unit) {
    composable(
        route = DetailsRoute.route(),
        arguments = listOf(navArgument(DetailsRoute.ARG_CAT_ID) { type = NavType.StringType }),
    ) {
        DetailScreen(onBackClick)
    }
}

public fun detailsRouteEntry(
    key: DetailsRouteNavKey,
    onBackClick: () -> Unit,
): NavEntry<NavKey> =
    NavEntry(
        key = key,
    ) {
        DetailScreen(onBackClick)
    }
