package com.elpablo.sportster.core.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings

fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}

sealed class Response<out T> {
    object Loading: Response<Nothing>()

    data class Success<out T>(
        val data: T?
    ): Response<T>()

    data class Failure(
        val e: Exception
    ): Response<Nothing>()
}

//fun FirebaseUser.toUser() = mapOf(
//    DISPLAY_NAME to displayName,
//    EMAIL to email,
//    PHOTO_URL to photoUrl?.toString(),
//    CREATED_AT to serverTimestamp()
//)