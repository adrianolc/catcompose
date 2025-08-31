package com.example.catcompose.features.details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.features.details.repo.DetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class DetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsViewState>(value = DetailsViewState.Loading)
    val state: StateFlow<DetailsViewState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = when (val result = detailsRepository.getCat(id)) {
                is NetworkResult.Success -> DetailsViewState.Success(result.data)
                is NetworkResult.Error -> DetailsViewState.Error(
                    result.exception.message ?: "Unknown error"
                )
            }
        }
    }
}