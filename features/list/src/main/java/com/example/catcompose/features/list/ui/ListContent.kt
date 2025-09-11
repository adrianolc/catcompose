package com.example.catcompose.features.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.catcompose.features.list.navigation.OnCatClick

@Composable
internal fun ListContent(
    modifier: Modifier,
    cats: List<Cat>,
    onCatClick: OnCatClick,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = cats,
            key = { it.id },
        ) { cat -> CatItem(cat, onCatClick) }
    }
}

@Composable
internal fun CatItem(
    cat: Cat,
    onCatClick: OnCatClick,
) {
    AsyncImage(
        modifier =
            Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clickable {
                    onCatClick(cat.id)
                },
        model = cat.url,
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
    )
}

@Preview
@Composable
fun CatItemPreview() {
    val cats =
        List(4) { index ->
            Cat(
                id = index.toString(),
                url = "https://cdn2.thecatapi.com/images/$index.jpg",
            )
        }

    MaterialTheme {
        ListContent(Modifier, cats) {
        }
    }
}
