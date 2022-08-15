package com.arsenijjke.favquotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arsenijjke.data.repository.RemoteRepositoryImpl
import kotlinx.coroutines.flow.*
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.models.QuoteX
import javax.inject.Inject

@HiltViewModel
class RemoteViewModel @Inject constructor(
    private val repository: RemoteRepositoryImpl
) : ViewModel() {

    private var _quoteOfTheDay = MutableStateFlow(QuoteOfTheDay("", QuoteX("", "", "")))
    val quoteOfTheDay: StateFlow<QuoteOfTheDay> get() = _quoteOfTheDay

    //Check if after moving to other fragment quote is saved return last
    suspend fun getQuote() {
        if (quoteOfTheDay.value.quote.body.isEmpty()) {
            repository.fetchQuote().collect {
                _quoteOfTheDay.value = it
            }
        } else {
            _quoteOfTheDay.value = quoteOfTheDay.value
        }
    }

}