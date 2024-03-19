package com.elpablo.sportster.domain.repository

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLocationUpdates(): Flow<Location>

    class LocationException(message: String): Exception()
}