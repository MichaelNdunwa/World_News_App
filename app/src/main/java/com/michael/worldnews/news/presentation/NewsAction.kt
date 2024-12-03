package com.michael.worldnews.news.presentation

sealed interface NewsAction {
    data object Paginate: NewsAction
}