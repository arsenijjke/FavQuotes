package com.arsenijjke.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.arsenijjke.data.network.QuoteService
import com.arsenijjke.data.db.dao.QuotesDao
import com.arsenijjke.data.db.models.FavouriteQuote
import com.arsenijjke.domain.models.Quote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class RetrofitRepository @Inject constructor(private val quoteService: QuoteService,
    private val dao: QuotesDao) {

    fun getAllQuotes(): LiveData<List<FavouriteQuote>> {
        return dao.getAllQuotes()
    }

    fun addQuote(quote: FavouriteQuote) {
        dao.addQuote(quote)
    }

    suspend fun getQuote(): Call<Quote> {
        return quoteService.getQuote()
    }

    /** TODO(Will implement with stateListener) */
    suspend fun apiCall() {
        val call: Call<Quote> = getQuote()
        call.enqueue(object : Callback<Quote> {
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                if(response.isSuccessful){
                    Log.d("API","Success")
                }
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                    Log.d("API","$t")
            }
        })
    }
}