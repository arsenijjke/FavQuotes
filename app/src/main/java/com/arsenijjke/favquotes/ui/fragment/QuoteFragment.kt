package com.arsenijjke.favquotes.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.R
import com.arsenijjke.domain.interfaces.AdapterController
import com.arsenijjke.favquotes.ui.adapter.QuoteAdapter
import com.arsenijjke.favquotes.databinding.FragmentQuoteBinding
import com.arsenijjke.favquotes.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_quote.motionLayout
import kotlinx.coroutines.*


@DelicateCoroutinesApi
@AndroidEntryPoint
class QuoteFragment : Fragment(R.layout.fragment_quote), AdapterController {

    private val binding: FragmentQuoteBinding by viewBinding()
    private val viewModel: QuoteViewModel by viewModels()
    private val adapter = QuoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {
            setupAdapter()
            fillAdapter()
            swipeLeft()
        }
    }

    private fun swipeLeft() {
        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenUnlike,
                    R.id.offScreenLike -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, R.id.detail)
                        GlobalScope.launch(Dispatchers.Main) {
                            cleanAdapterElements()
                            fillAdapter()
                        }
                    }
                }
            }
        })

    }

    override fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override suspend fun cleanAdapterElements() {
        adapter.quotes.removeFirst()
    }

    override suspend fun fillAdapter() {
        viewModel.getQuote().observe(this, {
            adapter.quotes.add(it)
            adapter.notifyItemInserted(0)
            adapter.notifyItemChanged(0)
        })
    }

    private fun toQuoteInfo() {
        //TODO("By swiping up, move to fragment with info about this quote")
    }

    private fun makeFavourite() {
        //TODO("By swiping right, add quote to favourites")
    }

}