package com.moomis.poiesis.data.models

data class Author (
    val name: String,
    val dob: String? = null,//date of birth
    val dod: String? = null,//date of death
    val poemsSaved: Int = 0,
    val imageURL: String? = null
)