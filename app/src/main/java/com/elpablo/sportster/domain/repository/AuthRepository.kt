package com.elpablo.sportster.domain.repository

import com.elpablo.sportster.core.utils.Response
import com.elpablo.sportster.domain.model.User
import com.google.firebase.auth.AuthCredential

interface AuthRepository {
    fun isUserAuthenticatedInFirebase(): Boolean
    suspend fun signIn(credential: AuthCredential): Response<Boolean>
    suspend fun signOut(): Response<Boolean>
    suspend fun writeUserToDB(): Response<Boolean>

    suspend fun getUser(): Response<User?>
}