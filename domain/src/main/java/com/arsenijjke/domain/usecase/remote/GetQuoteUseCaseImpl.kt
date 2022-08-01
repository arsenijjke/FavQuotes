package com.arsenijjke.domain.usecase.remote

import com.arsenijjke.domain.usecase.BaseUseCase
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.repository.QuoteRemoteRepository
import kotlinx.coroutines.flow.Flow

interface GetQuoteUseCase: BaseUseCase<QuoteOfTheDay>

class GetQuoteUseCaseImpl(
    private val quoteRemoteRepository: QuoteRemoteRepository
): GetQuoteUseCase {

    override suspend fun invoke(): Flow<QuoteOfTheDay> =
        quoteRemoteRepository.fetchQuote()

}