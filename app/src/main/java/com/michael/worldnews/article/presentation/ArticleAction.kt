package com.michael.worldnews.article.presentation

sealed interface ArticleAction {
    data class LoadArticle(val articleId: String) : ArticleAction
}