package com.elpablo.sportster.ui.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.elpablo.sportster.core.components.SportsterLoader
import com.elpablo.sportster.core.utils.Response.Loading
import com.elpablo.sportster.core.utils.Response.Success
import com.elpablo.sportster.core.utils.Response.Failure
import com.elpablo.sportster.ui.login.LoginViewModel
import com.google.android.gms.auth.api.identity.BeginSignInResult

@Composable
fun OneTapSignIn(
    viewModel: LoginViewModel = hiltViewModel(),
    launch: (result: BeginSignInResult) -> Unit
) {
    when(val oneTapSignInResponse = viewModel.oneTapSignInResponse) {
        is Loading -> SportsterLoader()
        is Success -> oneTapSignInResponse.data?.let {
            LaunchedEffect(it) {
                launch(it)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            print(oneTapSignInResponse.e)
        }
    }
}