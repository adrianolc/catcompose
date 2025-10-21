package com.example.catcompose.features.details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.features.details.repo.DetailsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = DetailsViewModel.Factory::class)
internal class DetailsViewModel
    @AssistedInject
    constructor(
        @Assisted private val catId: String,
        private val detailsRepository: DetailsRepository,
    ) : ViewModel() {
        private val _viewState = MutableStateFlow<DetailsViewState>(value = DetailsViewState.Loading)
        val viewState: StateFlow<DetailsViewState> = _viewState.asStateFlow()

        init {
            viewModelScope.launch {
                _viewState.value =
                    when (val result = detailsRepository.getCat(catId)) {
                        is NetworkResult.Success -> DetailsViewState.Success(result.data)
                        is NetworkResult.Error ->
                            DetailsViewState.Error(
                                result.exception.message ?: "Unknown error",
                            )
                    }
            }
        }

        @AssistedFactory
        interface Factory {
            fun create(catId: String): DetailsViewModel
        }
    }
