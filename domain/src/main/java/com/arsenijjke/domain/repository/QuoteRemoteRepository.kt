package com.arsenijjke.domain.repository

import kotlinx.coroutines.flow.Flow
import com.arsenijjke.domain.models.QuoteOfTheDay

interface QuoteRemoteRepository {
    suspend fun fetchQuote(): Flow<QuoteOfTheDay>
}