package com.moomis.poiesis.data.models

data class Poem (
    val author: Author,
    val title: String,
    val lineCount: Int,
    val body: String,
    val isSaved: Boolean
) {
    val preview: String
        get() {
            val lines = body.lines()
            if (lines.size <= 4) return body
            return lines.take(4).joinToString("\n") + " …"
        }
}