package com.example.catcompose.features.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.catcompose.features.details.ui.DetailScreen
import kotlinx.serialization.Serializable

@Serializable object DetailsRoute {
    private val baseRoute = "details"
    const val argument = "cat_id"

    fun route() = "${baseRoute}/${argument}"
    fun createRoute(id: String) = "${baseRoute}/${id}"
}

fun NavGraphBuilder.detailsScreen() {
    composable(
        route = DetailsRoute.route(),
        arguments = listOf(navArgument(DetailsRoute.argument) { type = NavType.StringType })
    ) {
        DetailScreen()
    }
}
