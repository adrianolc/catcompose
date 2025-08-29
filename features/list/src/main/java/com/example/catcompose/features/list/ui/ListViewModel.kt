package com.example.catcompose.features.list.ui

import androidx.lifecycle.ViewModel
import com.example.catcompose.features.list.api.ListService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listService: ListService,
) : ViewModel() {


}