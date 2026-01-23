package com.moomis.poiesis.data.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.moomis.poiesis.data.entities.PoemEntity
import com.moomis.poiesis.data.entities.PoemWithAuthor

@Dao
interface PoemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun savePoem(poemEntity: PoemEntity): Long

    @Delete
    suspend fun deletePoem(poemEntity: PoemEntity)

    @Transaction
    @Query("SELECT * from poems")
    suspend fun getAllPoems(): List<PoemWithAuthor>

}