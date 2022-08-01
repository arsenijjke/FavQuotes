package com.arsenijjke.domain.di

import com.arsenijjke.domain.repository.QuoteRemoteRepository
import com.arsenijjke.domain.repository.QuoteLocalRepository
import com.arsenijjke.domain.usecase.local.LendQuoteUseCase
import com.arsenijjke.domain.usecase.local.LendQuoteUseCaseImpl
import com.arsenijjke.domain.usecase.remote.GetQuoteUseCase
import com.arsenijjke.domain.usecase.remote.GetQuoteUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainUseCaseModule {

    @Provides
    @Singleton
    fun provideQuoteRemote(
        repository: QuoteRemoteRepository
    ): GetQuoteUseCase =
        GetQuoteUseCaseImpl(repository)

    @Provides
    @Singleton
    fun provideQuoteLocal(
        repository: QuoteLocalRepository
    ): LendQuoteUseCase =
        LendQuoteUseCaseImpl(repository)
}