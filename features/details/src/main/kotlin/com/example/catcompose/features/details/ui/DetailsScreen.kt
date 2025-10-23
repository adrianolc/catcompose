package com.example.catcompose.features.details.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun DetailScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: DetailsViewModel,
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    if (viewState.isLoading) {
        DetailsLoading()
    } else {
        viewState.cat?.let { cat ->
            CatDetailsContent(
                modifier = modifier,
                cat = cat,
                onBackClick = onBackClick,
            )
        }
    }
}
