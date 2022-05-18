package com.arsenijjke.favquotes.di

import android.content.Context
import com.arsenijjke.data.db.QuotesDatabase
import com.arsenijjke.data.db.dao.QuotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): QuotesDatabase {
        return QuotesDatabase.getQuotesDB(context)
    }

    @Singleton
    @Provides
    fun provideDao(db: QuotesDatabase): QuotesDao {
        return db.getDao()
    }
}