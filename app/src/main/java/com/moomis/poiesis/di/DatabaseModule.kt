package com.moomis.poiesis.di

import android.content.Context
import androidx.room.Room
import com.moomis.poiesis.data.PoemsDatabase
import com.moomis.poiesis.data.dao.AuthorDao
import com.moomis.poiesis.data.dao.PoemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PoemsDatabase {
        return Room.databaseBuilder(
            context,
            PoemsDatabase::class.java,
            "poems_database"
        ).build()
    }

    @Provides
    fun provideAuthorDao(database: PoemsDatabase): AuthorDao {
        return database.authorDao()
    }

    @Provides
    fun providePoemDao(database: PoemsDatabase): PoemDao {
        return database.poemDao()
    }
}