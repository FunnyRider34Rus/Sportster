package com.elpablo.sportster.ui.login

data class LoginViewState(
    val isUserLogged: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: String = ""
)
