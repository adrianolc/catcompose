package com.example.catcompose.features.details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.features.details.model.Cat
import com.example.catcompose.features.details.navigation.DetailsNavKey
import com.example.catcompose.features.details.repo.DetailsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = DetailsViewModel.Factory::class)
internal class DetailsViewModel
    @AssistedInject
    constructor(
        @Assisted private val detailsRoute: DetailsNavKey,
        private val detailsRepository: DetailsRepository,
    ) : ViewModel() {
        private val _viewState =
            MutableStateFlow(
                value =
                    DetailsViewState(
                        cat =
                            Cat(
                                id = detailsRoute.catId,
                                imageUrl = detailsRoute.imageUrl,
                                name = detailsRoute.catName,
                                breed = null,
                            ),
                        isLoading = true,
                    ),
            )

        val viewState: StateFlow<DetailsViewState> = _viewState.asStateFlow()

        init {
            viewModelScope.launch {
                when (val result = detailsRepository.getCat(detailsRoute.catId)) {
                    is NetworkResult.Success ->
                        _viewState.update {
                            it.copy(
                                cat = result.data,
                                isLoading = false,
                            )
                        }

                    is NetworkResult.Error ->
                        _viewState.update {
                            it.copy(
                                error = result.exception.message,
                                isLoading = false,
                            )
                        }
                }
            }
        }

        @AssistedFactory
        interface Factory {
            fun create(detailsRoute: DetailsNavKey): DetailsViewModel
        }
    }
