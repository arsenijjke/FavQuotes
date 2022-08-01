package com.arsenijjke.data.repository

import com.arsenijjke.data.network.QuoteService
import com.arsenijjke.domain.models.QuoteOfTheDay
import javax.inject.Inject


class RetrofitRepository @Inject constructor(private val quoteService: QuoteService) {

    suspend fun getQuoteFromRepository(): QuoteOfTheDay {
        return quoteService.getQuoteOfTheDay()
    }

}