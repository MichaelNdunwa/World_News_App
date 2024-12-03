package com.michael.worldnews

import android.app.Application
import com.michael.worldnews.article.di.articleModule
import com.michael.worldnews.core.di.coreModule
import com.michael.worldnews.news.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                coreModule,
                newsModule,
                articleModule
            )
        }
    }

}