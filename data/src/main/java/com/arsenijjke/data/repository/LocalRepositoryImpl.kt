package com.arsenijjke.data.repository

import com.arsenijjke.data.db.dao.QuotesDaoService
import com.arsenijjke.domain.repository.QuoteLocalRepository
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.data.db.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val daoService: QuotesDaoService
): QuoteLocalRepository {

    //todo refactor
    override suspend fun lendQuotes(): Flow<List<QuoteOfTheDay>> {
        val list = daoService.getAllQuotes().toList().first()
        val glist = mutableListOf<QuoteOfTheDay>()
        for(i in list.indices) {
            glist[i] = QuoteOfTheDay(list.first().quote.qotd_date,list.first().quote.quote)
        }
        return flowOf(glist)
    }

    override suspend fun addQuote(quote: QuoteOfTheDay) {
        daoService.insertQuote(quote.toEntity())
    }
}