package com.moomis.poiesis.data.repositories

import com.moomis.poiesis.data.DTOs.PoemDto
import com.moomis.poiesis.data.dataSources.PoemsRemoteDataSource

class PoemsRepository(private val poemsRemoteDataSource: PoemsRemoteDataSource) {
    //TODO check if poem exists in db (favorited)
    suspend fun fetchRandomPoems(): List<PoemDto> =
        poemsRemoteDataSource.fetchRandomPoems()
}