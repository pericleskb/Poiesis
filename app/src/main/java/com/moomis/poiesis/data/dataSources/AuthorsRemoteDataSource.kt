package com.moomis.poiesis.data.dataSources

import com.moomis.poiesis.data.DTOs.AuthorsResponseDto
import com.moomis.poiesis.network.OpenLibraryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AuthorsRemoteDataSource(
    private val openLibraryApi: OpenLibraryService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchAuthorDetails(name: String): AuthorsResponseDto =
        withContext(ioDispatcher) {
            val formattedName = name.split(" ").reduce { acc, string -> "$acc+$string" }
            return@withContext openLibraryApi.getAuthorsByName(formattedName)
        }
}