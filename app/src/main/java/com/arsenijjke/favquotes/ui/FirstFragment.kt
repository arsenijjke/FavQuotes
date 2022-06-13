package com.arsenijjke.favquotes.ui

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewAnimationUtils
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.R
import com.arsenijjke.favquotes.QuoteAdapter
import com.arsenijjke.favquotes.databinding.FragmentFirstBinding
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.models.QuoteX
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showNextQuote(viewModel)
    }

    private fun showNextQuote(viewModel: MainViewModel) {
        viewModel.getQuote().observe(this, {

        })
    }

    private fun setAdapter(quoteOfTheDay: QuoteOfTheDay) {
        val adapter = QuoteAdapter(quoteOfTheDay)

    }

    private fun toQuoteInfo() {
        //TODO("By swiping up, move to fragment with info about this quote")
    }

    private fun makeFavourite() {
        //TODO("By swiping right, add quote to favourites")
    }

}