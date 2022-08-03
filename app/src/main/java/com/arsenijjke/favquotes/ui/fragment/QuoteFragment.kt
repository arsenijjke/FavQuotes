package com.arsenijjke.favquotes.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.R
import com.arsenijjke.domain.interfaces.AdapterController
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.arsenijjke.favquotes.ui.adapter.QuoteAdapter
import com.arsenijjke.favquotes.databinding.FragmentQuoteBinding
import com.arsenijjke.favquotes.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_quote.*
import kotlinx.coroutines.*

@AndroidEntryPoint
class QuoteFragment : Fragment(R.layout.fragment_quote) {

    private val binding: FragmentQuoteBinding by viewBinding()
    private val viewModel: QuoteViewModel by viewModels()
    //  private var adapter = QuoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
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
                        lifecycleScope.launch(Dispatchers.Main) {
                            fillAdapter()
                            binding.btn.isEnabled = false
                            binding.cardOne.isEnabled = false
                        }
                    }
                }
            }
        })
        binding.btn.isEnabled = true
    }

    suspend fun fillAdapter() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getQuote()
            viewModel.viewModelScope.launch {
                viewModel.quoteOfTheDay.collect { data ->
                    binding.btn.isEnabled = true
                    binding.cardOne.isEnabled = true
                    binding.quoteBody.text = data.quote.body
                    binding.quoteAuthor.text = data.quote.author
                    // adapter.quotes.add(data)
                    // adapter.notifyItemInserted(0)
                    // adapter.notifyItemChanged(0)
                    // cleanAdapterElements()
                }
            }
        }
    }

    // private fun sendQuoteToInfo(): Bundle {
    //     val bundle = Bundle()
    //     bundle.putString("body", adapter.quotes.first().quote.body)
    //     bundle.putString("author", adapter.quotes.first().quote.author)
    //     bundle.putInt("likes", adapter.quotes.first().quote.upvotes_count)
    //     bundle.putInt("dislikes", adapter.quotes.first().quote.downvotes_count)
    //     return bundle
    // }

    // private fun toQuoteInfo() {
    //     binding.btn.setOnClickListener {
    //         val extras = FragmentNavigatorExtras(binding.cardOne to "receiveCard")
    //         findNavController().navigate(
    //             R.id.toInfo,
    //            // sendQuoteToInfo(),
    //             null,
    //             extras
    //         )
    //     }
//
    //     while (adapter.quotes.size > 0) {
    //         adapter.quotes.removeLast()
    //     }
    // }

    private fun makeFavourite() {
        //TODO("By swiping right, add quote to favourites")
    }

}