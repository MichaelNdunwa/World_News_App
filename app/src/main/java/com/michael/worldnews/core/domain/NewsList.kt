package com.michael.worldnews.core.domain


data class NewsList(
    val nextPage: String?,
    val articles: List<Article>,
    /* val status: String,
     val totalResults: Int*/
)