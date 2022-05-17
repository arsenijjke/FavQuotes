package com.arsenijjke.favquotes.di

import android.content.Context
import com.arsenijjke.data.db.QuotesDatabase
import com.arsenijjke.data.db.dao.QuotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): QuotesDatabase {
        return QuotesDatabase.getQuotesDB(context)
    }

    @Provides
    @Singleton
    fun provideDao(db: QuotesDatabase): QuotesDao {
        return db.getDao()
    }
}