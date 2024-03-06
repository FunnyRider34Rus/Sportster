package com.elpablo.sportster.ui.login

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
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState

    init {
        if (repository.isUserAuthenticatedInFirebase()) {
            _viewState.update {
                it.copy(
                    isUserLogged = true
                )
            }
        }
    }
    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginButtonClick -> {
                viewModelScope.launch {
                    when(val response = repository.signIn(event.credential)) {
                        is Response.Success -> {
                            _viewState.update {
                                it.copy(
                                    isLoading = false,
                                    isUserLogged = true
                                )
                            }
                        }
                        is Response.Loading -> {
                            _viewState.update {
                                it.copy(
                                    isLoading = true
                                )
                            }
                        }
                        is Response.Failure -> {
                            _viewState.update {
                                it.copy(
                                    isError = true,
                                    error = response.e.localizedMessage ?: "Unexpected error"
                                )
                            }
                        }
                    }
                }
            }
            is LoginEvent.Error -> {
                Log.d("sportster", event.errorMessage.toString())
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