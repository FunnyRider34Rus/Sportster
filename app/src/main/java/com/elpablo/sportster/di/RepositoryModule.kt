package com.elpablo.sportster.di

import android.app.Application
import com.elpablo.sportster.data.repository.DataStoreRepositoryImpl
import com.elpablo.sportster.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(application: Application): DataStoreRepository = DataStoreRepositoryImpl(application)
}