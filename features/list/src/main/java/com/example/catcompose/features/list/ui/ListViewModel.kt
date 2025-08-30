package com.example.catcompose.features.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.features.list.api.ListService
import com.example.catcompose.features.list.repo.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ListViewModel @Inject constructor(
    private val listRepository: ListRepository
) : ViewModel() {

    private val _state = MutableStateFlow<ListViewState>(value = ListViewState.Loading)
    val viewState: StateFlow<ListViewState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = when (val result = listRepository.getCats()) {
                is NetworkResult.Error -> ListViewState.Error(
                    message = result.exception.message ?: "Unknown error"
                )
                is NetworkResult.Success -> ListViewState.Success(cats = result.data)
            }
        }
    }
}