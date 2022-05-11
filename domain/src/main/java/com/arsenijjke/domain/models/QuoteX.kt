package com.arsenijjke.domain.models

data class QuoteX(
    val author: String,
    val author_permalink: String,
    val body: String,
    val dialogue: Boolean,
    val downvotes_count: Int,
    val favorite: Boolean,
    val favorites_count: Int,
    val id: Int,
    val tags: List<String>,
    val upvotes_count: Int,
    val url: String
)