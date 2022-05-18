package com.arsenijjke.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arsenijjke.data.db.models.FavouriteQuote

@Dao
interface QuotesDao {

    @Query("SELECT * FROM Quotes_DB")
    fun getAllQuotes(): LiveData<List<FavouriteQuote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuote(quote: FavouriteQuote)

    @Query("DELETE FROM Quotes_DB")
    fun deleteQuotes()
}