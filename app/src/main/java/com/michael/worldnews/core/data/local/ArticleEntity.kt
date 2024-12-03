package com.michael.worldnews.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
data class ArticleEntity(
    @PrimaryKey(autoGenerate = false)
    val articleId: String,

    val content: String,
    val description: String,
    val imageUrl: String,
    val pubDate: String,
    val sourceName: String,
    val title: String,
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