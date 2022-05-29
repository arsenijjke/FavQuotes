package com.arsenijjke.favquotes.ui

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
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
import kotlin.math.roundToInt

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showQuote(viewModel)
    }

    private fun showQuote(viewModel: MainViewModel) {
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
        ItemTouchHelper.RIGHT
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
            adapter.notifyItemRemoved(viewHolder.absoluteAdapterPosition)
            showQuote(viewModel)
        }

        override fun onChildDrawOver(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder?,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {

            super.onChildDrawOver(
                c, recyclerView, viewHolder,
                dX, dY, actionState, isCurrentlyActive
            )

            if (viewHolder != null) {
                c.clipRect(
                    0f, viewHolder.itemView.top.toFloat(),
                    dX, viewHolder.itemView.bottom.toFloat()
                )

                val width = viewHolder.itemView.left - viewHolder.itemView.right
                if (dX < width / 3)
                    c.drawColor(Color.GRAY)
                else
                    c.drawColor(resources.getColor(R.color.purple_200))
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            val trashBinIcon = resources.getDrawable(
                R.drawable.ic_baseline_favorite_border_24,
                null
            )

            val textMargin = resources.getDimension(R.dimen.text_margin)
                .roundToInt()

            if (viewHolder != null) {
                trashBinIcon.bounds = Rect(
                    textMargin,
                    viewHolder.itemView.top + textMargin,
                    textMargin + trashBinIcon.intrinsicWidth,
                    viewHolder.itemView.top + trashBinIcon.intrinsicHeight
                            + textMargin
                )

                trashBinIcon.draw(c)
            }

        }
    }

}