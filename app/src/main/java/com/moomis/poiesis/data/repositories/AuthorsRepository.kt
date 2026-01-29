package com.moomis.poiesis.data.repositories

import com.moomis.poiesis.data.dto.toModel
import com.moomis.poiesis.data.dataSources.AuthorsRemoteDataSource
import com.moomis.poiesis.data.models.Author
import javax.inject.Inject

class AuthorsRepository @Inject constructor(private val authorsRemoteDataSource: AuthorsRemoteDataSource) {

    suspend fun fetchAuthor(authorName: String): Author {
        val authorsResponse = authorsRemoteDataSource.fetchAuthorDetails(authorName)
        // If we found at least one author, return the first result
        return authorsResponse.authors.firstOrNull()?.toModel() ?: Author(name = authorName)
    }
}
