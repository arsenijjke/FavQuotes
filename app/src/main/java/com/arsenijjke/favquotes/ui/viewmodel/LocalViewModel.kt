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

    suspend fun getFavouriteQuotes() {
        repository.lendQuotes().collect {data ->
            _savedQuotes.value = data
        }
    }

    suspend fun addQuote(quote: QuoteOfTheDay) {
        repository.addQuote(quote)
    }



}