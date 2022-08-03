package com.arsenijjke.favquotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arsenijjke.data.repository.RemoteRepositoryImpl
import kotlinx.coroutines.flow.*
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.models.QuoteX
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: RemoteRepositoryImpl
) : ViewModel() {

    private var _quoteOfTheDay = MutableStateFlow(QuoteOfTheDay("", QuoteX("", "", "")))
    val quoteOfTheDay: StateFlow<QuoteOfTheDay> get() = _quoteOfTheDay

    suspend fun getQuote() {
        repository.fetchQuote().collect {
            _quoteOfTheDay.value = it
        }
    }

}