package com.moomis.poiesis.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moomis.poiesis.data.DAOs.AuthorDao
import com.moomis.poiesis.data.DAOs.PoemDao
import com.moomis.poiesis.data.entities.AuthorEntity
import com.moomis.poiesis.data.entities.PoemEntity

@Database(entities = [AuthorEntity::class, PoemEntity::class], version = 1, exportSchema = false)
abstract class PoemsDatabase: RoomDatabase() {
    abstract fun authorDao(): AuthorDao
    abstract fun poemDao(): PoemDao

    companion object {
        @Volatile
        private var Instance: PoemsDatabase? = null

        fun getDatabase(context: Context): PoemsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, PoemsDatabase::class.java, "poems_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}