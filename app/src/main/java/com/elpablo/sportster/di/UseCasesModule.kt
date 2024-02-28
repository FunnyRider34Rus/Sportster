package com.elpablo.sportster.di

import com.elpablo.sportster.domain.repository.DataStoreRepository
import com.elpablo.sportster.domain.usecases.AppEntryUseCases
import com.elpablo.sportster.domain.usecases.ReadAppEntry
import com.elpablo.sportster.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideAppEntryUseCases(repository: DataStoreRepository) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(repository),
        saveAppEntry = SaveAppEntry(repository)
    )
}