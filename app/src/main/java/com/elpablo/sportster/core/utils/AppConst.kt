package com.elpablo.sportster.core.utils

import android.Manifest
import androidx.compose.runtime.Immutable

@Immutable
object AppConst {
    const val DATASTORE_REF = "sportster"
    const val APP_ENTRY = "appEntry"
    //Collection References
    const val FIRESTORE_NODE_USERS = "users"


    val permissions = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
}