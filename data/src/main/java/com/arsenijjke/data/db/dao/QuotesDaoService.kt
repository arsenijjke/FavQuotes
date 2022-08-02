package com.arsenijjke.data.db.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.arsenijjke.data.db.models.QuoteEntity

@Dao
interface QuotesDaoService {

    @Transaction
    @Query("SELECT * FROM Quotes_DB")
    fun getAllQuotes(): Flow<List<QuoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuote(quote: QuoteEntity)

    @Query("DELETE FROM Quotes_DB")
    fun deleteQuotes()
}
