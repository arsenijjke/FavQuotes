package com.arsenijjke.favquotes.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import com.arsenijjke.data.repository.RoomRepository
import com.arsenijjke.domain.models.QuoteOfTheDay

class SavedQuotesViewModel @Inject constructor(private val repository: RoomRepository) {

    val savedQuote = MutableLiveData<QuoteOfTheDay>()

    fun getFavouriteQuotes() {
        repository.getAllQuotes()
    }
}