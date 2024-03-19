package com.elpablo.sportster.core.utils

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Immutable

@Immutable
object AppConst {

    //Location
    const val LOCATION_UPDATE_INTERVAL = 1000L
    const val LOCATION_SERVICE_ID = 1
    const val LOCATION_NOTIFICATION_CHANNEL_ID = "location"

    //Database
    const val DATASTORE_REF = "sportster"
    const val APP_ENTRY_PREFERENCES_KEY = "appEntry"

    //Firesbase
    const val FIRESTORE_NODE_USERS = "users"

    //Permissions
    @RequiresApi(Build.VERSION_CODES.P)
    val permissions = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.FOREGROUND_SERVICE
    )
}