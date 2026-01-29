package com.moomis.poiesis.data.dataSources

import com.moomis.poiesis.data.dto.AuthorsResponseDto
import com.moomis.poiesis.di.IoDispatcher
import com.moomis.poiesis.network.OpenLibraryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthorsRemoteDataSource @Inject constructor(
    private val openLibraryApi: OpenLibraryService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchAuthorDetails(name: String): AuthorsResponseDto =
        withContext(ioDispatcher) {
            val formattedName = name.split(" ").reduce { acc, string -> "$acc+$string" }
            return@withContext openLibraryApi.getAuthorsByName(formattedName)
        }
}