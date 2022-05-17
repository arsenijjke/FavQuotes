package com.arsenijjke.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arsenijjke.data.db.dao.QuotesDao
import com.arsenijjke.data.db.models.FavouriteQuote

@Database(entities = [FavouriteQuote::class], version = 1, exportSchema = false)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun getDao(): QuotesDao

    companion object {
        private var DB_INSTANCE: QuotesDatabase? = null

        fun getQuotesDB(context: Context): QuotesDatabase {
            if(DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext, QuotesDatabase::class.java,"Quotes_DB")
                    .allowMainThreadQueries()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}