package com.example.catcompose.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .addInterceptor {
            val newRequest = it.request()
                .newBuilder()
                .addHeader(
                    "x-api-key",
                    "live_LULEx6XMwa5EZvrwoS1dfa7mhyxQV2f9dEMwZqmjWM6PUDbC58nEyJ0WTNq1ge8d"
                )
                .build()

            it.proceed(newRequest)
        }
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(
        json: Json,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.thecatapi.com")
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()
}