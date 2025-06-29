package com.project.mandirinews.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)