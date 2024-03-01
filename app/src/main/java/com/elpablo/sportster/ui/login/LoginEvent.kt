package com.elpablo.sportster.ui.login

import com.google.firebase.auth.AuthCredential

sealed class LoginEvent {
    class OnLoginButtonClick(val credential: AuthCredential) : LoginEvent()
    class Error(val errorMessage: String?) : LoginEvent()
}