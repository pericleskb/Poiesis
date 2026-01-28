package com.moomis.poiesis.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "authors")
data class AuthorEntity(
    @PrimaryKey
    val authorId: Int,
    val name: String,
    val dob: String,
    val dod: String,
    val imageUrl: String
)

data class AuthorWithPoems(
    @Embedded val author: AuthorEntity,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "poemAuthorId"
    )
    val poems: List<PoemEntity>
)