package com.arsenijjke.favquotes.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.R
import com.arsenijjke.domain.interfaces.AdapterController
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.favquotes.ui.adapter.QuoteAdapter
import com.arsenijjke.favquotes.databinding.FragmentQuoteBinding
import com.arsenijjke.favquotes.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_quote.*
import kotlinx.coroutines.*

@DelicateCoroutinesApi
@AndroidEntryPoint
class QuoteFragment : Fragment(R.layout.fragment_quote), AdapterController {

    private val binding: FragmentQuoteBinding by viewBinding()
    private val viewModel: QuoteViewModel by viewModels()
    private var adapter = QuoteAdapter()

    private var tempArr: ArrayList<QuoteOfTheDay> = adapter.quotes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {
            setupAdapter()
            fillAdapter()
            swipeLeft()
        }

        toQuoteInfo()
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

    private fun sendQuoteToInfo(): Bundle {
        val bundle: Bundle = Bundle()
        bundle.putString("body",adapter.quotes[0].quote.body)
        bundle.putString("author",adapter.quotes[0].quote.author)
        bundle.putInt("likes",adapter.quotes[0].quote.upvotes_count)
        bundle.putInt("dislikes",adapter.quotes[0].quote.downvotes_count)
        return bundle
    }

    private fun toQuoteInfo() {
        binding.btn.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.cardOne to "receiveCard")
            findNavController().navigate(
                R.id.toInfo,
                sendQuoteToInfo(),
                null,
                extras
            )
        }

        while (adapter.quotes.size > 0) {
            adapter.quotes.removeLast()
        }
    }

    private fun makeFavourite() {
        //TODO("By swiping right, add quote to favourites")
    }

    /** As data refreshes after moving to QuoteInfo
     * on monday I will make function that sends data to shared transition
     * And after moving back it will represents the quote you read
     */

}