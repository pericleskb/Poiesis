package com.moomis.poiesis.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "poems")
data class PoemEntity(
    @PrimaryKey
    val poemId: Int,
    val authorId: Int,
    val title: String,
    val lineCount: Int,
    val body: String
)

data class PoemWithAuthor(
    @Embedded val poem: PoemEntity,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "poemId"
    )
    val author: AuthorEntity
)
