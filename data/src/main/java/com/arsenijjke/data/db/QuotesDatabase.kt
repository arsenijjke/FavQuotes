package com.arsenijjke.data.db

import android.content.Context
import androidx.room.*
import com.arsenijjke.data.db.dao.QuotesDao
import com.arsenijjke.data.db.models.FavouriteQuote
import com.arsenijjke.data.db.models.TypeConverterQuote

@Database(entities = [FavouriteQuote::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterQuote::class)
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