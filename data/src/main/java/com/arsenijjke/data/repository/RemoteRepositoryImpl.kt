package com.arsenijjke.data.repository

import com.arsenijjke.data.network.QuoteService
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.repository.QuoteRemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RemoteRepositoryImpl @Inject constructor(
    private val quoteService: QuoteService
) : QuoteRemoteRepository {

    override suspend fun fetchQuote(): Flow<QuoteOfTheDay> {
        return quoteService.getQuoteOfTheDay()
    }


}