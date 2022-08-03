package com.arsenijjke.data.db.mapper

import com.arsenijjke.domain.models.QuoteOfTheDay
import com.arsenijjke.data.db.models.QuoteEntity

fun QuoteOfTheDay.toEntity() = QuoteEntity(
    id = 0,
    author = this.quote.author,
    body = this.quote.body
)