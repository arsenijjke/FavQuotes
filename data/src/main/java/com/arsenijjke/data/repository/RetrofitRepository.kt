package com.arsenijjke.data.repository

import androidx.lifecycle.LiveData
import com.arsenijjke.data.network.QuoteService
import com.arsenijjke.data.db.dao.QuotesDao
import com.arsenijjke.data.db.models.FavouriteQuote
import com.arsenijjke.domain.models.QuoteOfTheDay
import javax.inject.Inject


class RetrofitRepository @Inject constructor(private val quoteService: QuoteService,
    private val dao: QuotesDao) {

    fun getAllQuotes(): LiveData<List<FavouriteQuote>> {
        return dao.getAllQuotes()
    }

    fun addQuote(quote: FavouriteQuote) {
        dao.addQuote(quote)
    }

    suspend fun getQuoteFromRepository(): QuoteOfTheDay {
        return quoteService.getQuoteOfTheDay()
    }

}