package com.arsenijjke.data.repository

import com.arsenijjke.data.network.QuoteService
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val quoteService: QuoteService) {
}