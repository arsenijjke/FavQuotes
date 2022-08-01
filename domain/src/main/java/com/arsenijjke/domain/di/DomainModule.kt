package com.arsenijjke.domain.di

import dagger.Module

@Module(
    includes = [
        DomainUseCaseModule::class
    ]
)
interface DomainModule