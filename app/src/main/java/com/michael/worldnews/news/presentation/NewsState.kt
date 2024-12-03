package com.michael.worldnews.news.presentation

import com.michael.worldnews.core.domain.Article

data class NewsState(
    val articleList: List<Article> = emptyList(),
    val nextPage: String? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
