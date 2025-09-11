package com.example.catcompose.features.list.ui

sealed interface ListViewState {
    data object Loading : ListViewState

    data class Success(
        val cats: List<Cat>,
    ) : ListViewState

    data class Error(
        val message: String,
    ) : ListViewState
}
