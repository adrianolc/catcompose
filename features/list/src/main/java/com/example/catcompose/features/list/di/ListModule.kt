package com.example.catcompose.features.list.di

import com.example.catcompose.features.list.api.ListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ListModule {
    @Provides
    @Singleton
    fun providesListService(retrofit: Retrofit): ListService = retrofit.create(ListService::class.java)
}
