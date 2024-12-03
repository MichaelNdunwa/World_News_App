package com.michael.worldnews.core.domain

sealed class NewsResult<T>(val data: T? = null) {
    class Success<T>(data: T?) : NewsResult<T>(data)
    class Error<T>() : NewsResult<T>(null)
}