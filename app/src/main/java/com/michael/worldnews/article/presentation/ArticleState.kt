package com.michael.worldnews.article.presentation

import com.michael.worldnews.core.domain.Article


data class ArticleState(
    val article: Article? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
