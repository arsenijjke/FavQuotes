package com.arsenijjke.favquotes.di

import com.arsenijjke.favquotes.network.QuoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@[Module InstallIn(SingletonComponent::class)]
class RetrofitModule {

    @Provides
    fun provideRetrofit(): QuoteService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://favqs.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}