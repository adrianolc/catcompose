package com.example.catcompose.features.details.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catcompose.core.designsystem.CatTheme
import com.example.catcompose.features.details.model.Breed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BreedContent(
    modifier: Modifier = Modifier,
    breed: Breed?,
) {
    val breed = breed ?: return

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = breed.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Origin: ${breed.origin}",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Preview
@Composable
private fun DetailContentPreview() {
    CatTheme {
        BreedContent(
            modifier = Modifier,
            breed =
                Breed(
                    temperament =
                        listOf(
                            "Active",
                            "Energetic",
                            "Independent",
                            "Intelligent",
                            "Gentle",
                        ),
                    description = "The Abyssinian is easy to care for and active cat who is. The Abyssinian is easy to care for and active cat who is. The Abyssinian is easy to care for and active cat who is. The Abyssinian is easy to care for and active cat who is. The Abyssinian is easy to care for and active cat who is",
                    origin = "Egypt",
                    wikipediaUrl = "https://en.wikipedia.org/wiki/Abyssinian_(cat)",
                    adaptability = 5,
                    affectionLevel = 5,
                    childFriendly = 3,
                    grooming = 2,
                    energyLevel = 5,
                ),
        )
    }
}
