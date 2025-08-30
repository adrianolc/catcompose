package com.example.catcompose.features.list.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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

    when (val currentViewState = viewState) {
        is ListViewState.Error -> {
            // no-op
        }
        is ListViewState.Loading -> {
            // no-op
        }
        is ListViewState.Success -> ListContent(modifier = modifier, cats = currentViewState.cats)
    }
}

@Composable
internal fun ListContent(
    modifier: Modifier,
    cats: List<Cat>
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = cats,
            key = { it.id }
        ) { cat -> CatItem(cat) }
    }
}

@Composable
internal fun CatItem(cat: Cat) {
    val ctx = LocalContext.current

    AsyncImage(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .clickable {
                Toast.makeText(ctx, "Meowww!!", Toast.LENGTH_SHORT).show()
            },
        model = cat.url,
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
    )
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

    MaterialTheme {
        ListContent(Modifier, cats)
    }
}