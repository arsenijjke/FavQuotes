package com.arsenijjke.favquotes.ui.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.transition.Visibility
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arsenijjke.favquotes.R
import com.arsenijjke.favquotes.databinding.FragmentQuoteInfoBinding
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding

class QuoteInfoFragment : Fragment(R.layout.fragment_quote_info) {

    private val binding: FragmentQuoteInfoBinding by viewBinding()

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
        val bundle = this.arguments
        binding.quoteBody.text = bundle?.getString("body")
        binding.quoteAuthor.text = bundle?.getString("author")
        binding.likeCounter.text = bundle?.getInt("likes").toString()
        binding.dislikeCounter.text = bundle?.getInt("dislikes").toString()
    }
}