package com.elpablo.sportster.data.repository

import com.elpablo.sportster.core.utils.AppConst.FIRESTORE_NODE_USERS
import com.elpablo.sportster.core.utils.Response
import com.elpablo.sportster.core.utils.Response.Failure
import com.elpablo.sportster.core.utils.Response.Success
import com.elpablo.sportster.domain.model.User
import com.elpablo.sportster.domain.repository.AuthRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {
    override fun isUserAuthenticatedInFirebase() = auth.currentUser?.uid != null

    override suspend fun signIn(credential: AuthCredential): Response<Boolean> {
        return try {
            Firebase.auth.signInWithCredential(credential).await()
            Success(true)
        } catch (error: Exception) {
            Failure(error)
        }
    }

    override suspend fun signOut(): Response<Boolean> {
        return try {
            auth.signOut()
            Success(true)
        } catch (error: Exception) {
            Failure(error)
        }
    }

    override suspend fun writeUserToDB(): Response<Boolean> {
        return try {
            val user = User(
                uid = auth.currentUser?.uid,
                displayName = auth.currentUser?.displayName,
                photoURL = auth.currentUser?.photoUrl.toString()
            )
            user.uid?.let { uid -> firestore.collection(FIRESTORE_NODE_USERS).document(uid).set(user).await() }
            Success(true)
        } catch (error: Exception) {
            Failure(error)
        }
    }

    override suspend fun getUser(): Response<User?> {
        return try {
            val user = User(
                uid = auth.currentUser?.uid,
                displayName = auth.currentUser?.displayName,
                photoURL = auth.currentUser?.photoUrl.toString()
            )
            Success(data = user)
        } catch (error: Exception) {
            Failure(error)
        }
    }
}