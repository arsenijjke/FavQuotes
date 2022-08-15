package com.arsenijjke.favquotes.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsenijjke.favquotes.R
import androidx.lifecycle.lifecycleScope
import com.arsenijjke.favquotes.ui.adapter.QuoteAdapter
import com.arsenijjke.favquotes.databinding.FragmentQuoteBinding
import com.arsenijjke.favquotes.ui.viewmodel.RemoteViewModel
import com.arsenijjke.favquotes.ui.viewmodel.LocalViewModel
import com.arsenijjke.domain.interfaces.AdapterController
import com.arsenijjke.domain.models.QuoteOfTheDay
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_quote.*

@AndroidEntryPoint
class QuoteFragment : Fragment(R.layout.fragment_quote), AdapterController {

    private val binding: FragmentQuoteBinding by viewBinding()
    private val remoteViewModel: RemoteViewModel by activityViewModels()
    private val localViewModel: LocalViewModel by viewModels()
    private var adapter = QuoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        swipe()
        toQuoteInfo()
    }

    private fun swipe() {
        motionLayout.setTransitionListener(object : TransitionAdapter() {
            @SuppressLint("NotifyDataSetChanged")
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offToDb -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, R.id.detail)
                        addToFavourite(adapter.quotes[0])
                        adapter.notifyDataSetChanged()
                        fillAdapter()
                        binding.btn.isEnabled = false
                        binding.cardOne.isEnabled = false
                    }
                    R.id.offNext -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, R.id.detail)
                        adapter.notifyDataSetChanged()
                        fillAdapter()
                        binding.btn.isEnabled = false
                        binding.cardOne.isEnabled = false
                    }
                }
            }
        })
    }

    // Implementation adapter functions region

    override fun fillAdapter() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            remoteViewModel.getQuote()
            remoteViewModel.quoteOfTheDay.collect { data ->
                binding.btn.isEnabled = true
                binding.cardOne.isEnabled = true
                adapter.quotes[0].quote.author = data.quote.author
                adapter.quotes[0].quote.body = data.quote.body
            }
        }
    }

    override fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    // Endregion

    // Quote Information Region

    private fun toQuoteInfo() {
        binding.btn.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.cardOne to "receiveCard")

            //findNavController().navigate(QuoteFragmentDirections.toSavedQuotes())

            findNavController().navigate(
                R.id.toInfo,
                bundleOf(),
                null,
                extras
            )
        }
    }
    // EndRegion

    private fun addToFavourite(quote: QuoteOfTheDay) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            localViewModel.addQuote(quote)
        }
    }

}

