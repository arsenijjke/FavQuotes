package com.arsenijjke.favquotes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.domain.models.QuoteX
import com.arsenijjke.favquotes.R
import kotlinx.android.synthetic.main.saved_quote_item.view.*

class SavedQuotesAdapter : RecyclerView.Adapter<SavedQuotesAdapter.ViewHolder>() {

    var quotes = mutableListOf<QuoteOfTheDay>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.quote_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.saved_quote_item, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.quote_author.text = quotes[position].quote.author
        holder.itemView.quote_body.text = quotes[position].quote.body
    }

    override fun getItemCount() = quotes.size


}