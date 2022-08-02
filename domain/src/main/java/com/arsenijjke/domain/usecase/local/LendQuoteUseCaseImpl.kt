package com.arsenijjke.domain.usecase.local

import com.arsenijjke.domain.usecase.BaseUseCase
import com.arsenijjke.domain.repository.QuoteLocalRepository
import com.arsenijjke.domain.models.QuoteOfTheDay
import kotlinx.coroutines.flow.Flow

interface LendQuoteUseCase : BaseUseCase<List<QuoteOfTheDay>>

class LendQuoteUseCaseImpl(
    private val quoteLocalRepository: QuoteLocalRepository
) : LendQuoteUseCase {

    override suspend fun invoke(): Flow<List<QuoteOfTheDay>> =
        quoteLocalRepository.lendQuotes()

}