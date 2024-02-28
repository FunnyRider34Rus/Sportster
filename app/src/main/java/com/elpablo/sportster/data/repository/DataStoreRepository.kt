package com.elpablo.sportster.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "sportster")
class DataStoreRepository(context: Context) {
    private object PreferencesKey {
        val sportsterKey = booleanPreferencesKey(name = "sportster_key")
    }

    private val dataStore = context.dataStore

    suspend fun saveStortsterState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.sportsterKey] = completed
        }
    }

    fun readSportsterState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val sportsterState = preferences[PreferencesKey.sportsterKey] ?: false
                sportsterState
            }
    }
}