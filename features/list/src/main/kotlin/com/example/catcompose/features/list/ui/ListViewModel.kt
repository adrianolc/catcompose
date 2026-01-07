package com.example.catcompose.features.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.features.list.repo.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ListViewModel
    @Inject
    constructor(
        private val listRepository: ListRepository,
    ) : ViewModel() {
        val viewState: StateFlow<ListViewState>
            field: MutableStateFlow<ListViewState> = MutableStateFlow<ListViewState>(value = ListViewState.Loading)

        init {
            viewModelScope.launch {
                listRepository
                    .getCats()
                    .onSuccess { cats ->
                        viewState.value = ListViewState.Success(cats = cats)
                    }.onFailure { exception ->
                        viewState.value =
                            ListViewState.Error(
                                message = exception.message ?: "Unknown error",
                            )
                    }
            }
        }
    }
