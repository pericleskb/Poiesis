package com.moomis.poiesis.data.repositories

import com.moomis.poiesis.data.dto.PoemDto
import com.moomis.poiesis.data.models.Poem
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class PoemsWithAuthorRepository(
    private val poemsRepository: PoemsRepository,
    private val authorsRepository: AuthorsRepository
) {
    suspend fun fetchRandomPoems(): List<Poem> =
        coroutineScope {
            val poemsList = poemsRepository.fetchRandomPoems()
            poemsList.map { dto ->
                async { addAuthor(dto) }
            }.awaitAll()
        }

    private suspend fun addAuthor(dto: PoemDto): Poem {
        val author = authorsRepository.fetchAuthor(dto.author)
        return Poem(
            author = author,
            title = dto.title,
            lineCount = dto.linecount,
            body = dto.lines.joinToString("\n"),
            isSaved = false
        )
    }
}
