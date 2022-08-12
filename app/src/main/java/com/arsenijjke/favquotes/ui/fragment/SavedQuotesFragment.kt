package com.arsenijjke.favquotes.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.domain.interfaces.AdapterController
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.favquotes.R
import com.arsenijjke.favquotes.ui.adapter.SavedQuotesAdapter
import com.arsenijjke.favquotes.ui.viewmodel.LocalViewModel
import com.arsenijjke.favquotes.databinding.FragmentSavedQuotesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SavedQuotesFragment : Fragment(R.layout.fragment_saved_quotes), AdapterController {

    private val binding: FragmentSavedQuotesBinding by viewBinding()
    private val viewModel: LocalViewModel by viewModels()
    private val adapter: SavedQuotesAdapter = SavedQuotesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        fillAdapter()
    }

    override fun setupAdapter() {
        val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.recyclerView.adapter = adapter
    }

    override fun fillAdapter() {
        lifecycleScope.launch {
            for(i in viewModel.getFavouriteQuotes().indices) {
                adapter.quotes[i].quote.body = viewModel.getFavouriteQuotes()[i].quote.body
                adapter.quotes[i].quote.author = viewModel.getFavouriteQuotes()[i].quote.author
            }
        }
    }

}