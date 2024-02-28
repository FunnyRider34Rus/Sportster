package com.elpablo.sportster.domain.usecases

import com.elpablo.sportster.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val repository: DataStoreRepository) {
    suspend operator fun invoke(): Flow<Boolean> {
        return repository.readAppEntry()
    }
}