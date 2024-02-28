package com.elpablo.sportster.domain.usecases

import com.elpablo.sportster.domain.repository.DataStoreRepository

class SaveAppEntry(private val repository: DataStoreRepository) {
    suspend operator fun invoke() {
        repository.saveAppEntry()
    }
}