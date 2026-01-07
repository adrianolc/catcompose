package com.example.catcompose.features.details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.features.details.model.Cat
import com.example.catcompose.features.details.navigation.DetailsNavKey
import com.example.catcompose.features.details.repo.DetailsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = DetailsViewModel.Factory::class)
internal class DetailsViewModel
    @AssistedInject
    constructor(
        @Assisted private val detailsRoute: DetailsNavKey,
        private val detailsRepository: DetailsRepository,
    ) : ViewModel() {
        val viewState: StateFlow<DetailsViewState>
            field: MutableStateFlow<DetailsViewState> =
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

        init {
            viewModelScope.launch {
                detailsRepository
                    .getCat(detailsRoute.catId)
                    .onSuccess { cat ->
                        viewState.update {
                            it.copy(
                                cat = cat,
                                isLoading = false,
                            )
                        }
                    }.onFailure { exception ->
                        viewState.update {
                            it.copy(
                                error = exception.message,
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
