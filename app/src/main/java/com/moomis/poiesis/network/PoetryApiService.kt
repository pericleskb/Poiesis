package com.moomis.poiesis.network

import com.moomis.poiesis.data.apiModels.PoemDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL ="https://poetrydb.org/"

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

object PoetryApi {
    val retrofitService: PoetryApiService by lazy {
        retrofit.create(PoetryApiService::class.java)
    }
}

interface PoetryApiService {
    @GET("random/10")
    suspend fun getRandomPoems(): List<PoemDto>
}