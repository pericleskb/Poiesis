package com.moomis.poiesis.data.models

data class Author (
    val name: String,
    val dob: String,//date of birth
    var dod: String?,//date of death
    val poemsSaved: Int,
    val imageURL: String
) {
    fun getLifeTime() = if (!dod.isNullOrBlank()) "$dob - $dod" else dob
}