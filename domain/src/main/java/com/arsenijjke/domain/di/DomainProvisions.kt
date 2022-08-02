package com.arsenijjke.domain.di

import com.arsenijjke.domain.usecase.local.LendQuoteUseCase
import com.arsenijjke.domain.usecase.remote.GetQuoteUseCase

interface DomainProvisions {

    val validateColorUseCase: LendQuoteUseCase

    val getColorDetailsUseCase: GetQuoteUseCase
}