package com.example.catcompose.features.details.di

import com.example.catcompose.features.details.api.DetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DetailModule {
    @Provides
    @Singleton
    fun provideDetailsService(retrofit: Retrofit): DetailsService =
        retrofit.create(DetailsService::class.java)
}