package com.arsenijjke.favquotes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arsenijjke.domain.models.QuoteOfTheDay
import androidx.recyclerview.widget.RecyclerView
import com.arsenijjke.domain.models.QuoteX
import com.arsenijjke.favquotes.R

class QuoteAdapter : RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

    var quotes = mutableListOf(
        QuoteOfTheDay(
            "",
            QuoteX("arsenijjke","","Welcome to FavQuotes")
        )
    )

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // val name = binding.quoteBody
        // val body = binding.quoteBody
        val name = view.findViewById<TextView>(R.id.quote_author)
        val body = view.findViewById<TextView>(R.id.quote_body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_list_item,parent,false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = quotes.first().quote.author
        holder.body.text = quotes.first().quote.body

    }

    override fun getItemCount(): Int {
        return quotes.size
    }

}

