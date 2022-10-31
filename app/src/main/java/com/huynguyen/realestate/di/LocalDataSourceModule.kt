package com.huynguyen.realestate.di

import com.huynguyen.realestate.data.local.LocalDataSource
import com.huynguyen.realestate.data.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun providesLocalSource(
        localStorageService: LocalDataSourceImpl
    ): LocalDataSource
}