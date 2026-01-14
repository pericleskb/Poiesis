package com.moomis.poiesis.data.dataSources

import com.moomis.poiesis.data.apiModels.PoemDto
import com.moomis.poiesis.network.PoetryApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PoemsRemoteDataSource(
    private val poetryApi: PoetryApiService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchRandomPoems(): List<PoemDto> =
        withContext(ioDispatcher) {
            poetryApi.getRandomPoems()
        }
}