package com.arsenijjke.favquotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arsenijjke.domain.models.QuoteOfTheDay
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(
    private val quoteOfTheDay: QuoteOfTheDay,
) : RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

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
            holder.name.text = quoteOfTheDay.quote.author
            holder.body.text = quoteOfTheDay.quote.body
    }

    override fun getItemCount(): Int {
        return 1
    }

}