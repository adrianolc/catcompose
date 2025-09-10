package com.example.catcompose.features.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun DetailsLoading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .shimmer()
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(modifier
                .height(24.dp)
                .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Temperament:", fontWeight = FontWeight.SemiBold)
            Box(modifier
                .height(34.dp)
                .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Description:", fontWeight = FontWeight.SemiBold)
            Box(modifier
                .height(34.dp)
                .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Characteristics:", fontWeight = FontWeight.SemiBold)
            BreedStatsRow("Adaptability", 5)
            BreedStatsRow("Affection", 4)
            BreedStatsRow("Child Friendly", 3)
            BreedStatsRow("Grooming", 2)
            BreedStatsRow("Energy", 1)
        }
    }
}

@Preview
@Composable
fun DetailsLoadingPreview() {
    DetailsLoading()
}
