package com.elpablo.sportster.ui.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.elpablo.sportster.core.components.SportsterLoader
import com.elpablo.sportster.core.utils.Response.Loading
import com.elpablo.sportster.core.utils.Response.Success
import com.elpablo.sportster.core.utils.Response.Failure
import com.elpablo.sportster.ui.login.LoginViewModel

@Composable
fun SignInWithGoogle(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToMainScreen: (signedIn: Boolean) -> Unit
) {
    when(val signInWithGoogleResponse = viewModel.signInWithGoogleResponse) {
        is Loading -> SportsterLoader()
        is Success -> signInWithGoogleResponse.data?.let { signedIn ->
            LaunchedEffect(signedIn) {
                navigateToMainScreen(signedIn)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            print(signInWithGoogleResponse.e)
        }
    }
}