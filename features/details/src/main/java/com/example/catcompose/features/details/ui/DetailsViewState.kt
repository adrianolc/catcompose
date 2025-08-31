package com.example.catcompose.features.details.ui

import com.example.catcompose.features.details.repo.Cat

internal sealed interface DetailsViewState {
    object Loading : DetailsViewState
    data class Error(val message: String) : DetailsViewState
    data class Success(val cat: Cat) : DetailsViewState
}
