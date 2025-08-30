package com.example.catcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.catcompose.navigation.CatNavHost

@Composable
fun CatApp(
    modifier: Modifier = Modifier,
) {
    CatNavHost(
        navController = rememberNavController(),
        modifier = modifier,
    )
}