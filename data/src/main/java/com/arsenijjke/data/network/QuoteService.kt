package com.arsenijjke.data.network

import com.arsenijjke.domain.models.QuoteOfTheDay
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface QuoteService {

    @GET("/api/qotd")
    suspend fun getQuoteOfTheDay() : Flow<QuoteOfTheDay>

}