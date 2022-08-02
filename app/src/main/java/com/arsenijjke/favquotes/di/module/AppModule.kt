package com.arsenijjke.favquotes.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(
    includes = [
        AppViewModelModule::class
    ]
)
interface AppModule