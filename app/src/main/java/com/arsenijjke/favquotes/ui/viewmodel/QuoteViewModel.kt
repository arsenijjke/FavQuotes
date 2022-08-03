package com.arsenijjke.favquotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arsenijjke.data.repository.RemoteRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.*
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.models.QuoteX
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: RemoteRepositoryImpl
    ) : ViewModel() {

    init {
        getQuote()
    }

    var _quoteOfTheDay = MutableStateFlow(QuoteOfTheDay("", QuoteX("","","")))
    val quoteOfTheDay: StateFlow<QuoteOfTheDay> get() = _quoteOfTheDay

    fun getQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchQuote().collect { it ->
                _quoteOfTheDay.value = it
            }
        }
    }

}