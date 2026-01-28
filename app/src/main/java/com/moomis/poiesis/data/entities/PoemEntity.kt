package com.moomis.poiesis.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poems")
data class PoemEntity(
    @PrimaryKey
    val poemId: Int,
    val poemAuthorId: Int,
    val title: String,
    val lineCount: Int,
    val body: String
)
