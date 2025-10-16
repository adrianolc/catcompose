package com.example.catcompose.features.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.catcompose.features.details.ui.DetailScreen

public object DetailsRoute {
    private const val BASE_ROUTE = "details"
    public const val ARG_CAT_ID: String = "cat_id"

    public fun route(): String = "${BASE_ROUTE}/{${ARG_CAT_ID}}"

    public fun createRoute(id: String): String = "${BASE_ROUTE}/$id"
}

public fun NavGraphBuilder.detailsScreen(onBackClick: () -> Unit) {
    composable(
        route = DetailsRoute.route(),
        arguments = listOf(navArgument(DetailsRoute.ARG_CAT_ID) { type = NavType.StringType }),
    ) {
        DetailScreen(onBackClick)
    }
}
