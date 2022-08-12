package com.arsenijjke.favquotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import com.arsenijjke.data.repository.LocalRepositoryImpl
import kotlinx.coroutines.flow.*
import com.arsenijjke.domain.models.QuoteOfTheDay
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LocalViewModel @Inject constructor(
    private val repository: LocalRepositoryImpl
) : ViewModel() {

    private var _savedQuotes = MutableStateFlow<List<QuoteOfTheDay>>(listOf())
    val savedQuotes: StateFlow<List<QuoteOfTheDay>> get() = _savedQuotes

    suspend fun getFavouriteQuotes(): List<QuoteOfTheDay> {
        var list = listOf<QuoteOfTheDay>()
        repository.lendQuotes().collect {data ->
            list = data
        }
        return list
    }

    suspend fun addQuote(quote: QuoteOfTheDay) {
        repository.addQuote(quote)
    }

}