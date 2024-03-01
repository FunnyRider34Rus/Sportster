package com.elpablo.sportster.di

import android.app.Application
import com.elpablo.sportster.data.repository.AuthRepositoryImpl
import com.elpablo.sportster.data.repository.DataStoreRepositoryImpl
import com.elpablo.sportster.domain.repository.AuthRepository
import com.elpablo.sportster.domain.repository.DataStoreRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth, firestore: FirebaseFirestore): AuthRepository =
        AuthRepositoryImpl(auth, firestore)
}