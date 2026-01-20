package com.moomis.poiesis.data.repositories

import com.moomis.poiesis.data.DTOs.toModel
import com.moomis.poiesis.data.dataSources.PoemsRemoteDataSource
import com.moomis.poiesis.data.models.Poem

class PoemsRepository(private val poemsRemoteDataSource: PoemsRemoteDataSource) {
    //TODO check if poem exists in db (favorited)
    suspend fun fetchRandomPoems(): List<Poem> =
        poemsRemoteDataSource.fetchRandomPoems().map { it.toModel() }
}