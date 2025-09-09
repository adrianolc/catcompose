package com.example.catcompose.features.details.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.catcompose.features.details.repo.Cat

@Composable
internal fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    when (val state = viewState) {
        is DetailsViewState.Error -> {
            // no-op
        }

        is DetailsViewState.Loading -> {
            // no-op
        }

        is DetailsViewState.Success -> CatDetailContent(modifier = modifier, cat = state.cat)
    }
}

@Composable
private fun CatDetailContent(
    modifier: Modifier,
    cat: Cat
) {
    val breed = cat.breed
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        AsyncImage(
            model = cat.url,
            contentDescription = breed?.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (breed == null) return

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = breed.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Origin: ${breed.origin}",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Temperament:", fontWeight = FontWeight.SemiBold)
            Text(text = breed.temperament)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Description:", fontWeight = FontWeight.SemiBold)
            Text(text = breed.description)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Characteristics:", fontWeight = FontWeight.SemiBold)
            BreedStatsRow("Adaptability", breed.adaptability)
            BreedStatsRow("Affection", breed.affectionLevel)
            BreedStatsRow("Child Friendly", breed.childFriendly)
            BreedStatsRow("Grooming", breed.grooming)
            BreedStatsRow("Energy", breed.energyLevel)

            Spacer(modifier = Modifier.height(20.dp))


            Button(
                onClick = { uriHandler.openUri(breed.wikipediaUrl) },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Open Wikipedia")
            }
        }
    }
}

@Composable
private fun BreedStatsRow(label: String, value: Int) {
    Row(
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Text(
            text = "$label:",
            modifier = Modifier.width(120.dp)
        )

        repeat(5) { index ->
            val filled = index < value
            Text(text = if (filled) "★" else "☆")
        }
    }
}
