package com.project.mandirinews.repository

import com.project.mandirinews.model.Article
import com.project.mandirinews.network.NewsApiService

class NewsRepository {

    private val api = NewsApiService.create()
    private val API_KEY = "c8b6cb51f1794e43bbb12ba1f97b4f47"


    suspend fun getTopHeadlines(page: Int): List<Article> {
        val response = api.getTopHeadlines(
            country = "us",
            page = page,
            pageSize = 20,
            apiKey = API_KEY
        )

        return if (response.isSuccessful) {
            response.body()?.articles ?: emptyList()
        } else {
            emptyList()
        }
    }

}