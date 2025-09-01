package com.example.catcompose.features.details.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.repo.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val id: String = checkNotNull(savedStateHandle[DetailsRoute.ARG_CAT_ID]) {
        "id is required"
    }

    private val _viewState = MutableStateFlow<DetailsViewState>(value = DetailsViewState.Loading)
    val viewState: StateFlow<DetailsViewState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.value = when (val result = detailsRepository.getCat(id)) {
                is NetworkResult.Success -> DetailsViewState.Success(result.data)
                is NetworkResult.Error -> DetailsViewState.Error(
                    result.exception.message ?: "Unknown error"
                )
            }
        }
    }
}