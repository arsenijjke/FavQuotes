package com.arsenijjke.favquotes.di

import android.app.Application
import com.arsenijjke.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
class RepositoryModule {

    @Provides
    fun provideRepository(application: Application): MainRepository {
        return MainRepository(application)
    }
}