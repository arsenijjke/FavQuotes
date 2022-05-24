package com.arsenijjke.favquotes

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arsenijjke.data.repository.RetrofitRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RetrofitRepository)
    : ViewModel() {

    suspend fun getQuote() {
        repository.apiCall()
    }

    fun getFavouriteQuotes() {
        repository.getAllQuotes()
    }

}