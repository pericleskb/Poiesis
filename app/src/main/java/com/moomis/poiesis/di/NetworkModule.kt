package com.moomis.poiesis.di

import com.moomis.poiesis.network.OpenLibraryService
import com.moomis.poiesis.network.PoetryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("PoetryRetrofit")
    fun providePoetryRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://poetrydb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("OpenLibraryRetrofit")
    fun provideOpenLibraryRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://openlibrary.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePoetryService(@Named("PoetryRetrofit") retrofit: Retrofit): PoetryService {
        return retrofit.create(PoetryService::class.java)
    }

    @Provides
    @Singleton
    fun provideOpenLibraryService(@Named("OpenLibraryRetrofit") retrofit: Retrofit): OpenLibraryService {
        return retrofit.create(OpenLibraryService::class.java)
    }
}