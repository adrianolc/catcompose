package com.example.catcompose.features.list.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage

@Composable
internal fun ListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = hiltViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    when (val current = viewState) {
        is ListViewState.Error -> TODO()
        is ListViewState.Loading -> TODO()
        is ListViewState.Success -> Content(modifier = modifier, cats = current.cats)
    }
}

@Composable
internal fun Content(
    modifier: Modifier,
    cats: List<Cat>
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        items(
            items = cats,
            key = { it.id }) { cat -> CatItem(cat) }
    }
}

@Composable
internal fun CatItem(cat: Cat) {
    val ctx = LocalContext.current

    Box(
        modifier = Modifier.clickable {
            Toast.makeText(ctx, cat.id, Toast.LENGTH_SHORT).show()
        }
    ) {
        AsyncImage(
            model = cat.url,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Preview
@Composable
fun CatItemPreview() {
    val cats = List(4) { index ->
        Cat(
            id = index.toString(),
            url = "https://cdn2.thecatapi.com/images/${index}.jpg",
        )
    }

    Content(Modifier, cats)
}