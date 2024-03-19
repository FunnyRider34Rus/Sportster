package com.elpablo.sportster.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.sportster.core.navigation.Graph
import com.elpablo.sportster.domain.usecases.AppEntryUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(appEntryUseCases: AppEntryUseCases) :
    ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Graph.ONBOARD.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry.invoke().collect { isFirstStart ->
                if (isFirstStart) {
                    _startDestination.value = Graph.MAIN.route
                } else {
                    _startDestination.value = Graph.ONBOARD.route
                }
            }
            _isLoading.value = true
        }
    }
}