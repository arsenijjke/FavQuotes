package com.arsenijjke.favquotes.di.module

import com.arsenijjke.domain.usecase.remote.GetQuoteUseCase
import com.arsenijjke.domain.usecase.remote.GetQuoteUseCaseImpl
import com.arsenijjke.domain.usecase.local.LendQuoteUseCase
import com.arsenijjke.domain.usecase.local.LendQuoteUseCaseImpl
import com.arsenijjke.data.repository.RemoteRepositoryImpl
import com.arsenijjke.data.repository.LocalRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideGetQuoteUseCase(remoteRepository: RemoteRepositoryImpl): GetQuoteUseCase {
        return GetQuoteUseCaseImpl(remoteRepository)
    }

    @Singleton
    @Provides
    fun provideLendQuoteUseCase(localRepository: LocalRepositoryImpl): LendQuoteUseCase {
        return LendQuoteUseCaseImpl(localRepository)
    }


}