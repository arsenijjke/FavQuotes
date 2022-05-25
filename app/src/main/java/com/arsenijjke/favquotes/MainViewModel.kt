package com.arsenijjke.favquotes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arsenijjke.data.repository.RetrofitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.arsenijjke.domain.models.QuoteOfTheDay
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RetrofitRepository) : ViewModel() {

    fun getQuote(): MutableLiveData<QuoteOfTheDay> {

        val quoteOfTheDay = MutableLiveData<QuoteOfTheDay>()

        viewModelScope.launch(Dispatchers.IO) {

              val date = repository.getQuoteFromRepository().qotd_date
              val quote = repository.getQuoteFromRepository().quote

            quoteOfTheDay.postValue(QuoteOfTheDay(date,quote))
        }
        return quoteOfTheDay
    }

    fun getFavouriteQuotes() {
        repository.getAllQuotes()
    }

}