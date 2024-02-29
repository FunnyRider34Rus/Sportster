package com.elpablo.sportster.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}