package com.elpablo.sportster.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.sportster.core.navigation.Graph
import com.elpablo.sportster.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(appEntryUseCases: AppEntryUseCases):
    ViewModel() {

    var splashState by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Graph.ONBOARD.route)
        private set

    init {
        appEntryUseCases.readAppEntry.invoke().onEach { shouldShowStartScreen ->
            startDestination = if (shouldShowStartScreen) {
                Graph.MAIN.route
            } else {
                Graph.ONBOARD.route

            }
            splashState = false
        }.launchIn(viewModelScope)
    }
}