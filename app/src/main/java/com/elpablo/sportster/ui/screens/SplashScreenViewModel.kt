package com.elpablo.sportster.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.sportster.core.navigation.Screen
import com.elpablo.sportster.data.repository.DataStoreRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(private val repository: DataStoreRepository): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.START.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readSportsterState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screen.DASHBOARD.route
                } else {
                    _startDestination.value = Screen.START.route
                }
            }
            _isLoading.value = false
        }
    }
}