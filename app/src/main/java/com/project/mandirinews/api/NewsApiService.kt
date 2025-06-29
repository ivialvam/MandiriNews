package com.project.mandirinews.network

import com.project.mandirinews.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "id",
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 20,
        @Query("apiKey") apiKey: String = "c8b6cb51f1794e43bbb12ba1f97b4f47"
    ): Response<NewsResponse>

    companion object {
        fun create(): NewsApiService {
            return retrofit2.Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
                .create(NewsApiService::class.java)
        }
    }
}