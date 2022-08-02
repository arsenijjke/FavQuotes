package com.arsenijjke.domain.di

import com.arsenijjke.domain.repository.QuoteRemoteRepository
import com.arsenijjke.domain.repository.QuoteLocalRepository

interface DomainDependencies {

    val quoteLocalRepository: QuoteLocalRepository
    val quoteRemoteRepository: QuoteRemoteRepository
}