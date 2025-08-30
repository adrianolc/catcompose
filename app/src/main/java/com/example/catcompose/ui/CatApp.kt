package com.example.catcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.catcompose.navigation.CatNavHost

@Composable
fun CatApp(
    modifier: Modifier = Modifier,
) {
    Scaffold { padding ->
        CatNavHost(
            navController = rememberNavController(),
            modifier = modifier.padding(paddingValues = padding),
        )
    }
}