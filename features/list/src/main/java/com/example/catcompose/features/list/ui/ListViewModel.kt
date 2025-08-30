package com.example.catcompose.features.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catcompose.features.list.api.ListService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listService: ListService,
) : ViewModel() {

    private val _state = MutableStateFlow<ListViewState>(ListViewState.Loading)
    val viewState: StateFlow<ListViewState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val list = listService.getCats(10)
                .map { Cat(it.id, it.url) }

            _state.value = ListViewState.Success(list)
        }
    }
}