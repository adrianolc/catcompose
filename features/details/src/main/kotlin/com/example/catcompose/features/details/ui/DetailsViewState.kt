package com.example.catcompose.features.details.ui

import com.example.catcompose.features.details.model.Cat

internal data class DetailsViewState(
    val cat: Cat,
    val isLoading: Boolean,
    val error: String? = null,
)
