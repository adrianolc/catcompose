package com.example.catcompose.features.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.catcompose.features.details.ui.DetailScreen

object DetailsRoute {
    private const val BASE_ROUTE = "details"
    const val ARG_CAT_ID = "cat_id"

    fun route() = "${BASE_ROUTE}/{${ARG_CAT_ID}}"

    fun createRoute(id: String) = "${BASE_ROUTE}/$id"
}

fun NavGraphBuilder.detailsScreen() {
    composable(
        route = DetailsRoute.route(),
        arguments = listOf(navArgument(DetailsRoute.ARG_CAT_ID) { type = NavType.StringType }),
    ) {
        DetailScreen()
    }
}
