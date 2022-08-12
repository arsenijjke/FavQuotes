package com.arsenijjke.domain.repository

import kotlinx.coroutines.flow.Flow
import com.arsenijjke.domain.models.QuoteOfTheDay

interface QuoteLocalRepository {

    suspend fun lendQuotes(): Flow<List<QuoteOfTheDay>>

    suspend fun addQuote(quote: QuoteOfTheDay)

    suspend fun deleteQuote()
}