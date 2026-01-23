package com.moomis.poiesis.data.DTOs

import com.google.gson.annotations.SerializedName
import com.moomis.poiesis.data.models.Author

data class AuthorsResponseDto(
    @SerializedName("docs")
    val authors: List<AuthorDto>
)

data class AuthorDto(
    val key: String,
    val name: String,

    @SerializedName("birth_date")
    val birthDate: String?,

    @SerializedName("death_date")
    val deathDate: String?
)

fun AuthorDto.toModel(): Author {
    return Author(
        name = name,
        dob = birthDate,
        dod = deathDate,
        imageUrl = "https://covers.openlibrary.org/a/olid/$key-M.jpg"
    )
}
