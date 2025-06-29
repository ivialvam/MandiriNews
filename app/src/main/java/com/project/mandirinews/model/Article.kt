package com.project.mandirinews.model

data class Article(
    val source: Source? = null,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
