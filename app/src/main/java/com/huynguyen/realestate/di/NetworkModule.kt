package com.huynguyen.realestate.di

import com.huynguyen.realestate.di.annotation.AuthorizedRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @AuthorizedRetrofit
    fun provideAuthorizedRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://private-9f1bb1-homegate3.apiary-mock.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().apply {
                    readTimeout(60, TimeUnit.SECONDS)
                    connectTimeout(60, TimeUnit.SECONDS)
                }.build()
            )
            .build()
    }
}

