package com.arsenijjke.favquotes.ui.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import com.arsenijjke.favquotes.R
import com.arsenijjke.favquotes.databinding.FragmentQuoteInfoBinding
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding

class QuoteInfoFragment : Fragment(R.layout.fragment_quote_info) {

    private val binding: FragmentQuoteInfoBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val anim = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = anim
        sharedElementReturnTransition = anim
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val anim = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = anim
        sharedElementReturnTransition = anim
    }
}