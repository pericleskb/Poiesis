package com.moomis.poiesis.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.moomis.poiesis.data.entities.AuthorEntity
import com.moomis.poiesis.data.entities.AuthorWithPoems

@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAuthor(author: AuthorEntity): Long

    @Query("SELECT * from authors WHERE authorId = :id")
    suspend fun getAuthor(id: Int)

    @Delete
    suspend fun deleteAuthor(author: AuthorEntity)

    @Transaction
    @Query("SELECT * from authors")
    suspend fun getAllAuthorsWithPoems(): List<AuthorWithPoems>

    @Transaction
    @Query("SELECT * from authors WHERE authorId = :id")
    suspend fun getAuthorWithPoems(id: Int): AuthorWithPoems
}