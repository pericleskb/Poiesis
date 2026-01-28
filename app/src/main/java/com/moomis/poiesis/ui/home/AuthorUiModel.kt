package com.moomis.poiesis.ui.home

import com.moomis.poiesis.data.models.Author

//TODO Look into another way of handling missing values from API calls
data class AuthorUi(
    val name: String,
    val dob: String,
    val dod: String,
    val poemsSaved: Int,
    val imageUrl: String
) {
    fun getLifeTime() = if (!dod.isEmpty()) "$dob - $dod" else dob
}

fun Author.toUiModel(): AuthorUi = AuthorUi(
    name = name,
    dob = dob ?: "",
    dod = dod ?: "",
    poemsSaved = poemsSaved,
    imageUrl = imageUrl ?: ""
)
