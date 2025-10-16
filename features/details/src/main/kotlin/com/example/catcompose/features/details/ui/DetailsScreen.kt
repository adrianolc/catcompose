package com.example.catcompose.features.details.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun DetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel(),
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
