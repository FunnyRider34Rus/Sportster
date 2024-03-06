package com.elpablo.sportster.ui.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.sportster.core.utils.Response
import com.elpablo.sportster.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    private val _viewState = MutableStateFlow(DashboardViewState())
    val viewState: StateFlow<DashboardViewState> = _viewState
    init {
        Log.d("sportster", repository.isUserAuthenticatedInFirebase().toString())
        if (repository.isUserAuthenticatedInFirebase()) {
            _viewState.update {
                it.copy(
                    isUserLogged = true
                )
            }

            viewModelScope.launch {
                when(val response = repository.getUser()) {
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

    fun onEvent(event: DashboardEvent) {
        when(event) {
            is DashboardEvent.Error -> {
                _viewState.update {
                    it.copy(
                        isError = true,
                        error = event.errorMessage ?: "Unexpected error"
                    )
                }
            }
        }
    }
}