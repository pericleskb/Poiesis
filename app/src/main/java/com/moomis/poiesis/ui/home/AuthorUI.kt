package com.moomis.poiesis.ui.home

import com.moomis.poiesis.data.models.Author

data class AuthorUi(
    val name: String,
    val dob: String,
    val dod: String,
    val poemsSaved: Int,
    val imageUrl: String
) {
    fun getLifeTime() = if (!dod.isEmpty()) "$dob - $dod" else dob
}

fun Author.toUi(): AuthorUi = AuthorUi(
    name = name,
    dob = dob ?: "",
    dod = dod ?: "",
    poemsSaved = poemsSaved,
    imageUrl = imageURL ?: ""
)
