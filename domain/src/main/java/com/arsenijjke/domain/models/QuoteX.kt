package com.arsenijjke.domain.models

data class QuoteX(
    var author: String,
    val author_permalink: String = "",
    var body: String,
    val dialogue: Boolean = false,
    val downvotes_count: Int = 0,
    val favorite: Boolean = false,
    val favorites_count: Int = 0,
    val id: Int = 0,
    val tags: List<String> = emptyList(),
    val upvotes_count: Int = 0,
    val url: String = ""
)