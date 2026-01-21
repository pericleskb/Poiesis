package com.moomis.poiesis.data.dataSources

import com.moomis.poiesis.data.DTOs.PoemDto
import com.moomis.poiesis.network.PoetryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PoemsRemoteDataSource(
    private val poetryApi: PoetryService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchRandomPoems(): List<PoemDto> =
        withContext(ioDispatcher) { //make fetchRandomPoems main-safe
            poetryApi.getRandomPoems()
        }
}