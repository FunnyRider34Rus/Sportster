package com.elpablo.sportster.ui.dashboard

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.sportster.core.services.LocationService
import com.elpablo.sportster.core.utils.Response
import com.elpablo.sportster.domain.repository.AuthRepository
import com.elpablo.sportster.domain.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val scope = viewModelScope
    private val _viewState = MutableStateFlow(DashboardViewState())
    val viewState: StateFlow<DashboardViewState> = _viewState

    init {
        Log.d("sportster", authRepository.isUserAuthenticatedInFirebase().toString())
        if (authRepository.isUserAuthenticatedInFirebase()) {
            _viewState.update {
                it.copy(
                    isUserLogged = true
                )
            }

            viewModelScope.launch {
                when (val response = authRepository.getUser()) {
                    is Response.Failure -> {
                        _viewState.update {
                            it.copy(
                                isError = true,
                                error = response.e.localizedMessage ?: "Unexpected error"
                            )
                        }
                    }

                    Response.Loading -> {
                        _viewState.update {
                            it.copy(isLoading = true)
                        }
                    }

                    is Response.Success -> {
                        _viewState.update {
                            it.copy(user = response.data)
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun updateCurrentLocation(context: Context) {
        scope.launch {
            locationRepository.getLocationUpdates().collect { location ->
                _viewState.update {
                    it.copy(
                        location = location
                    )
                }
            }
        }
    }

    fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.Error -> {
                _viewState.update {
                    it.copy(
                        isError = true,
                        error = event.errorMessage ?: "Unexpected error"
                    )
                }
            }

            is DashboardEvent.Location -> {
                updateCurrentLocation(event.context)
            }

            is DashboardEvent.TrainingStart -> {
                if (viewState.value.startTrainig) {
                    Intent(event.context, LocationService::class.java).apply {
                        action = LocationService.ACTION_STOP
                        (event.context as Activity).startService(this)

                    }
                } else {
                    Intent(event.context, LocationService::class.java).apply {
                        action = LocationService.ACTION_START
                        (event.context as Activity).startService(this)
                    }
                }
                _viewState.update {
                    it.copy(
                        startTrainig = !it.startTrainig
                    )
                }
            }
        }
    }
}