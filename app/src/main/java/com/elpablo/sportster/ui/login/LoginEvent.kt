package com.elpablo.sportster.ui.login

import com.google.firebase.auth.AuthCredential

sealed class LoginEvent {
    class onLoginButtonClick(val credential: AuthCredential) : LoginEvent()
    class Error(val errorMessage: String?) : LoginEvent()
}