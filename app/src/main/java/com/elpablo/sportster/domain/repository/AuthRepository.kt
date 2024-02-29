package com.elpablo.sportster.domain.repository

import com.elpablo.sportster.core.utils.Response
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.firebase.auth.AuthCredential

typealias OneTapSignInResponse = Response<BeginSignInResult>
typealias SignInWithGoogleResponse = Response<Boolean>
typealias SignOutResponse = Response<Boolean>
typealias RevokeAccessResponse = Response<Boolean>
interface AuthRepository {
    val isUserAuthenticatedInFirebase: Boolean
    suspend fun oneTapSignInWithGoogle(): OneTapSignInResponse
    suspend fun firebaseSignInWithGoogle(googleCredential: AuthCredential): SignInWithGoogleResponse
    suspend fun signOut(): SignOutResponse
    suspend fun revokeAccess(): RevokeAccessResponse
}