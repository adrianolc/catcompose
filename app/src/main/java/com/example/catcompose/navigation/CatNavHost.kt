package com.example.catcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.catcompose.features.list.navigation.ListRoute
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
        listScreen()
    }
}
