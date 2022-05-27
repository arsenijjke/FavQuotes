package com.arsenijjke.favquotes

import android.media.MediaRouter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = viewModel()
        showQuote(viewModel)
    }

    private fun showQuote(viewModel: MainViewModel) {

        binding.buttonFirst.setOnClickListener {
            val quote = viewModel.getQuote()

            viewModel.getQuote().observe(this, {
                binding.quoteAuthor.text = quote.value?.quote?.author
                binding.quoteBody.text = quote.value?.quote?.body
            })
        }
    }

    fun onSwipe() {
        val swipeGesture = object : SwipeGesture() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when(direction) {

                    ItemTouchHelper.UP -> {
                        toQuoteInfo()
                    }

                    ItemTouchHelper.RIGHT -> {
                        makeFavourite()
                    }
                }

                super.onSwiped(viewHolder, direction)
            }
        }
    }

    private fun toQuoteInfo() {
        //TODO("By swiping up, move to fragment with info about this quote")
    }

    private fun makeFavourite() {
        //TODO("By swiping right, add quote to favourites")
    }

    private fun viewModel(): MainViewModel {
        return ViewModelProvider(this)[MainViewModel::class.java]
    }

}