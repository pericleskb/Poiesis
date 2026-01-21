package com.moomis.poiesis.network

import com.moomis.poiesis.data.DTOs.AuthorsResponseDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL ="https://openlibrary.org/"

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//TODO replace Singleton with DI
object OpenLibraryApi {
    val openLibraryApiService: OpenLibraryService by lazy {
        retrofit.create(OpenLibraryService::class.java)
    }
}

interface OpenLibraryService {
    @GET("search/authors.json")
    suspend fun getAuthorsByName(@Query("q") authorName: String): AuthorsResponseDto
}