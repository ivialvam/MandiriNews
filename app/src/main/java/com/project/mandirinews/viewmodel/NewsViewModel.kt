package com.project.mandirinews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mandirinews.model.Article
import com.project.mandirinews.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var currentPage = 1

    init {
        loadMoreArticles()
    }

    fun loadMoreArticles() {
        _isLoading.value = true
        viewModelScope.launch {
            val newArticles = repository.getTopHeadlines(currentPage)
            if (newArticles.isNotEmpty()) {
                _articles.value = _articles.value + newArticles
                currentPage++
            }
            _isLoading.value = false
        }
    }

    fun refresh() {
        currentPage = 1
        viewModelScope.launch {
            _isLoading.value = true
            val freshArticles = repository.getTopHeadlines(currentPage)
            _articles.value = freshArticles
            _isLoading.value = false
        }
    }
}
