package com.example.dellin.data

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {

    private val dataStore = context.createDataStore("dellin_preferences")
    private val preferencesFlow = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Timber.e(exception, "Error reading preferences")
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }

    val lastPlayedSong: Flow<String> = preferencesFlow.map { preferences -> preferences[LAST_PLAYED_SONG_KEY] ?: "" }

    suspend fun updateLastSong(str : String) {
        dataStore.edit { preferences ->
            preferences[LAST_PLAYED_SONG_KEY] = str
        }
    }

    companion object {
        val LAST_PLAYED_SONG_KEY = preferencesKey<String>(name = "last_Played_song")
    }
}