package com.arsenijjke.data.network

import com.arsenijjke.domain.models.Quote
import com.arsenijjke.domain.models.QuoteOfTheDay
import retrofit2.http.GET
import retrofit2.Call

interface QuoteService {

    @GET("/api/quotes/:quote_id")
    suspend fun getQuote() : Call<Quote>

    @GET("/api/qotd")
    suspend fun getQuoteOfTheDay() : QuoteOfTheDay

}