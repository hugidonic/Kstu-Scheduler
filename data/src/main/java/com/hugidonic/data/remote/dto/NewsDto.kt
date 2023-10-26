package com.hugidonic.data.remote.dto

data class NewsDto(
    val newsId: Int,
    val title: String,
    val date: String,
    val imageUrl: List<String>,
    val text: String,
)