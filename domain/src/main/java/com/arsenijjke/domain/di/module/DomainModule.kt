package com.arsenijjke.domain.di

import com.arsenijjke.domain.di.module.DomainUseCaseModule
import dagger.Module

@Module(
    includes = [
        DomainUseCaseModule::class
    ]
)
interface DomainModule