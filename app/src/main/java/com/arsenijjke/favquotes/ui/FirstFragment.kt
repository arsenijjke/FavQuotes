package com.arsenijjke.favquotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.R
import com.arsenijjke.favquotes.QuoteAdapter
import com.arsenijjke.favquotes.databinding.FragmentFirstBinding
import com.arsenijjke.domain.models.QuoteOfTheDay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showQuote(getViewModel())
    }

    private fun showQuote(viewModel: MainViewModel) {
        binding.buttonFirst.setOnClickListener {
            viewModel.getQuote().observe(this, {
                setAdapter(it)
            })
        }
    }

    private fun setAdapter(quoteOfTheDay: QuoteOfTheDay) {
        val adapter = QuoteAdapter(quoteOfTheDay)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun toQuoteInfo() {
        //TODO("By swiping up, move to fragment with info about this quote")
    }

    private fun makeFavourite() {
        //TODO("By swiping right, add quote to favourites")
    }

    private fun getViewModel(): MainViewModel {
        return ViewModelProvider(this)[MainViewModel::class.java]
    }

}