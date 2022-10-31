package com.huynguyen.realestate.di

import com.huynguyen.realestate.data.network.services.EstateService
import com.huynguyen.realestate.di.annotation.AuthorizedRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideEstateService(@AuthorizedRetrofit retrofit: Retrofit) =
        retrofit.create(EstateService::class.java)

}