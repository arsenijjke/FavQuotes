package com.arsenijjke.data.network

import com.arsenijjke.domain.models.Quote
import com.arsenijjke.domain.models.QuoteOfTheDay
import retrofit2.http.GET

interface QuoteService {

    @GET("/api/quotes/:quote_id")
    suspend fun getQuoteFromApi() : Quote

    @GET("/api/qotd")
    suspend fun getQuoteOfTheDay() : QuoteOfTheDay

}