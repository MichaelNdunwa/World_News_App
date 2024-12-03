package com.michael.worldnews.article.di

import com.michael.worldnews.article.presentation.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val articleModule = module {
    viewModel { ArticleViewModel(get()) }
}