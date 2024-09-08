package com.google.vincent031525.rangerpedia.di

import com.google.vincent031525.rangerpedia.data.data_source.remote.RemoteDataSource
import com.google.vincent031525.rangerpedia.data.repository.MainRepositoryImpl
import com.google.vincent031525.rangerpedia.domain.repository.MainRepository
import com.google.vincent031525.rangerpedia.domain.use_case.GetPvpRankUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(DefaultRequest) {
                url("https://rangers.lerico.net")
            }
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
                engine {
                    connectTimeout = 10_000
                    socketTimeout = 10_000
                }
            }
        }
    }

    @Provides
    @Singleton
    fun providePvpRankUseCase(repository: MainRepository):GetPvpRankUseCase {
        return GetPvpRankUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMainRepository(remoteDataSource: RemoteDataSource): MainRepository {
        return MainRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(httpClient: HttpClient): RemoteDataSource {
        return RemoteDataSource(httpClient)
    }
}