package com.example.catcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.example.catcompose.navigation.CatNavDisplay

@Composable
fun CatApp(modifier: Modifier = Modifier) {
    CatNavDisplay(
        modifier =
            modifier.semantics {
                testTagsAsResourceId = true
            },
    )
}
