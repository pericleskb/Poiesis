package com.moomis.poiesis.data.repositories

import com.moomis.poiesis.data.dto.PoemDto
import com.moomis.poiesis.data.dataSources.PoemsRemoteDataSource
import javax.inject.Inject

class PoemsRepository @Inject constructor(private val poemsRemoteDataSource: PoemsRemoteDataSource) {
    //TODO check if poem exists in db (favorited)
    suspend fun fetchRandomPoems(): List<PoemDto> =
        poemsRemoteDataSource.fetchRandomPoems()
}