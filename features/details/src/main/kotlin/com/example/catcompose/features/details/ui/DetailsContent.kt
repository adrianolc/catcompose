package com.example.catcompose.features.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.catcompose.core.designsystem.CatTheme
import com.example.catcompose.features.details.repo.Breed
import com.example.catcompose.features.details.repo.Cat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CatDetailContent(
    modifier: Modifier,
    cat: Cat,
    onBackClick: () -> Unit,
) {
    val breed = cat.breed
    val uriHandler = LocalUriHandler.current

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .testTag("cat_details"),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState()),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(540.dp),
            ) {
                AsyncImage(
                    model = cat.url,
                    contentDescription = breed?.name,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )

                Box(
                    modifier =
                        Modifier
                            .matchParentSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                                    startY = 200f,
                                ),
                            ),
                )

                Column(
                    modifier =
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp),
                ) {
                    Text(
                        text = breed?.name ?: "",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        breed?.temperament?.forEach {
                            AssistChip(
                                onClick = { /* no-op */ },
                                label = {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.bodySmall,
                                    )
                                },
                                shape = RoundedCornerShape(percent = 50),
                                colors =
                                    AssistChipDefaults.assistChipColors(
                                        containerColor = Color.White.copy(alpha = 0.15f),
                                        labelColor = Color.White,
                                    ),
                                border = null,
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (breed == null) return

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

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Characteristics:",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                BreedStatsRow("Adaptability", breed.adaptability)
                BreedStatsRow("Affection", breed.affectionLevel)
                BreedStatsRow("Child Friendly", breed.childFriendly)
                BreedStatsRow("Grooming", breed.grooming)
                BreedStatsRow("Energy", breed.energyLevel)

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { uriHandler.openUri(breed.wikipediaUrl) },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                ) {
                    Text("Open Wikipedia")
                }
            }
        }

        TopAppBar(
            title = {},
            modifier = Modifier.statusBarsPadding(),
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back",
                    )
                }
            },
            colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                ),
        )
    }
}

@Composable
internal fun BreedStatsRow(
    label: String,
    value: Int,
) {
    Row(
        modifier = Modifier.padding(vertical = 2.dp),
    ) {
        Text(
            text = "$label:",
            modifier = Modifier.width(120.dp),
            color = MaterialTheme.colorScheme.onBackground,
        )

        repeat(5) { index ->
            val filled = index < value
            Text(
                text = if (filled) "★" else "☆",
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}

@Preview
@Composable
private fun DetailContentPreview() {
    val cat =
        Cat(
            id = "1",
            url = "https://cdn2.thecatapi.com/images/PN0d8Zqg7.jpg",
            breed =
                Breed(
                    id = "1",
                    name = "Abyssinian",
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

    CatTheme {
        CatDetailContent(
            modifier = Modifier,
            cat = cat,
        ) { }
    }
}
