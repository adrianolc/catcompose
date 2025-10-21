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

    when (val state = viewState) {
        is DetailsViewState.Error -> {
            // no-op
        }

        is DetailsViewState.Loading -> DetailsLoading(modifier)

        is DetailsViewState.Success ->
            CatDetailContent(
                modifier = modifier,
                cat = state.cat,
                onBackClick = onBackClick,
            )
    }
}
