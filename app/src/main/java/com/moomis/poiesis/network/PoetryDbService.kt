package com.moomis.poiesis.network

import com.moomis.poiesis.data.dto.PoemDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL ="https://poetrydb.org/"

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//TODO replace Singleton with DI
object PoetryApi {
    val poetryService: PoetryService by lazy {
        retrofit.create(PoetryService::class.java)
    }
}

interface PoetryService {
    @GET("random/10")
    suspend fun getRandomPoems(): List<PoemDto>
}