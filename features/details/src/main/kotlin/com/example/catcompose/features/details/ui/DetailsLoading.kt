package com.example.catcompose.features.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
internal fun DetailsLoading(modifier: Modifier = Modifier) {
    Column(
        modifier =
            Modifier
                .shimmer()
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
    ) {
        Box(
            modifier
                .height(18.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier
                .height(18.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier
                .height(18.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier
                .height(18.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier
                .height(18.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier
                .size(height = 24.dp, width = 120.dp)
                .background(Color.LightGray),
        )
    }
}

@Preview
@Composable
internal fun DetailsLoadingPreview() {
    DetailsLoading()
}
