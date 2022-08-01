package com.arsenijjke.domain.repository

import kotlinx.coroutines.flow.Flow
import com.arsenijjke.domain.models.QuoteOfTheDay

interface QuoteLocalRepository {

    fun lendQuotes(): Flow<List<QuoteOfTheDay>>
}