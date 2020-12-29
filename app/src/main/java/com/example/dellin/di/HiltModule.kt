package com.example.dellin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideOkHttpClient(): HttpClient = HttpClient {
        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    @Provides
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}