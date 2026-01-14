package com.moomis.poiesis.data.apiModels

import com.moomis.poiesis.data.models.Poem

data class PoemDto (
    val author: String,
    val title: String,
    val lineCount: Int,
    val body: String,
)

fun PoemDto.toModel() : Poem {
    return Poem(
        author,
        title,
        lineCount,
        body,
        false
    )
}