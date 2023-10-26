package com.hugidonic.domain.models

data class NewsModel(
    val newsId: Int,
    val newsType: String,
    val title: String,
    val date: String,
    val imageUrl: List<String>,
    val text: String,
)