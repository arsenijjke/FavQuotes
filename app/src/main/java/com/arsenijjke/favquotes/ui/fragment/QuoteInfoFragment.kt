package com.arsenijjke.favquotes.ui.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import com.arsenijjke.favquotes.ui.viewmodel.RemoteViewModel
import com.arsenijjke.favquotes.R
import com.arsenijjke.favquotes.databinding.FragmentQuoteInfoBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding

class QuoteInfoFragment : Fragment(R.layout.fragment_quote_info) {

    private val binding: FragmentQuoteInfoBinding by viewBinding()
    private val viewModel: RemoteViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnim()
    }

    private fun setAnim() {
        val anim = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = anim
        sharedElementReturnTransition = anim
    }

    private fun setUI() {
        binding.quoteBody.text = viewModel.quoteOfTheDay.value.quote.body
        binding.quoteAuthor.text = viewModel.quoteOfTheDay.value.quote.author
        binding.likeCounter.text = viewModel.quoteOfTheDay.value.quote.upvotes_count.toString()
        binding.dislikeCounter.text = viewModel.quoteOfTheDay.value.quote.upvotes_count.toString()
    }
}