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
            setAdapter(it)
            val myHelper = ItemTouchHelper(callback)
            myHelper.attachToRecyclerView(binding.recyclerView)
        })
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

    /** Animation */
    private val callback = object : ItemTouchHelper.SimpleCallback(
        0,
        ItemTouchHelper.RIGHT or ItemTouchHelper.UP
    ) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = false

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val adapter = QuoteAdapter(
                QuoteOfTheDay(
                    "", QuoteX(
                        "", "", "", false, 0, false, 0, 0, emptyList(), 0, ""
                    )
                )
            )


            when (direction) {
                ItemTouchHelper.RIGHT -> {
                    circularRevealCard()
                    adapter.notifyItemRemoved(viewHolder.absoluteAdapterPosition)
                    showNextQuote(viewModel)
                }
                ItemTouchHelper.UP -> {
                    toQuoteInfo()
                }
            }
        }

        override fun onMoved(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            fromPos: Int,
            target: RecyclerView.ViewHolder,
            toPos: Int,
            x: Int,
            y: Int
        ) {

            super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y)
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun circularRevealCard() {
        // get the right and bottom side
        // lengths of the reveal layout

        binding.recyclerContainer.background = resources.getDrawable(R.color.black)

        val recX: Int = binding.recyclerContainer.left
        val recY: Int = binding.recyclerContainer.top

        // here the starting radius of the reveal
        // layout is 0 when it is not visible
        val startRadius = 0

        // make the end radius should match
        // the while parent view
        val endRadius = Math.hypot(
            binding.recyclerContainer.width.toDouble(),
            binding.recyclerContainer.bottom.toDouble()
        ).toInt()

        binding.recyclerContainer.background = resources.getDrawable(R.drawable.simple_background)
        val recyclerAnim = ViewAnimationUtils.createCircularReveal(
            binding.recyclerContainer,
            recX,
            recY,
            startRadius.toFloat(),
            endRadius.toFloat(),
        )
        recyclerAnim.start()

    }


}