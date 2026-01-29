package com.moomis.poiesis.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moomis.poiesis.data.entities.PoemEntity

@Dao
interface PoemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun savePoem(poemEntity: PoemEntity): Long

    @Delete
    suspend fun deletePoem(poemEntity: PoemEntity)

    @Query("SELECT * from poems")
    suspend fun getAllPoems(): List<PoemEntity>

}