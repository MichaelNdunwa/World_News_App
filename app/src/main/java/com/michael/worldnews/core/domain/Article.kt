package com.michael.worldnews.core.domain


data class Article(
    val articleId: String,
    val title: String,
    val description: String,
    val content: String,
    val pubDate: String,
    val sourceName: String,
    val imageUrl: String
//    val ai_org: String,
//    val ai_region: String,
//    val ai_tag: String,
//    val category: List<String>,
//    val country: List<String>,
//    val creator: List<String>,
//    val duplicate: Boolean,
//    val keywords: List<String>,
//    val language: String,
//    val link: String,
//    val pubDateTZ: String,
//    val sentiment: String,
//    val sentiment_stats: String,
//    val source_icon: String,
//    val source_id: String,
//    val source_priority: Int,
//    val source_url: String,
//    val video_url: Any
)