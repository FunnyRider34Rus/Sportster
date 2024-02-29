package com.elpablo.sportster.core.utils

import android.Manifest
import androidx.compose.runtime.Immutable

@Immutable
object AppConst {
    const val DATASTORE_REF = "sportster"
    const val APP_ENTRY = "appEntry"

    val permissions = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACTIVITY_RECOGNITION
    )
}