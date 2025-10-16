package com.example.catcompose.features.list.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catcompose.features.list.navigation.OnCatClick

@Composable
internal fun ListScreen(
    onCatClick: OnCatClick,
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = hiltViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    when (val currentViewState = viewState) {
        is ListViewState.Error -> {
            // no-op
        }

        is ListViewState.Loading -> ListLoading(modifier)

        is ListViewState.Success ->
            ListContent(
                modifier = modifier,
                cats = currentViewState.cats,
                onCatClick = onCatClick,
            )
    }
}
