package com.arsenijjke.data.repository

import androidx.lifecycle.LiveData
import com.arsenijjke.data.db.dao.QuotesDaoService
import com.arsenijjke.data.db.models.FavouriteQuote
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val dao: QuotesDaoService
) {

    fun getAllQuotes(): LiveData<List<FavouriteQuote>> {
        return dao.getAllQuotes()
    }

    fun addQuote(quote: FavouriteQuote) {
        dao.addQuote(quote)
    }
}