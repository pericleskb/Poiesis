package com.moomis.poiesis.data.dataSources

import com.moomis.poiesis.data.dto.PoemDto
import com.moomis.poiesis.di.IoDispatcher
import com.moomis.poiesis.network.PoetryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PoemsRemoteDataSource @Inject constructor(
    private val poetryApi: PoetryService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchRandomPoems(): List<PoemDto> =
        withContext(ioDispatcher) { //make fetchRandomPoems main-safe
            poetryApi.getRandomPoems()
        }
}