package com.hugidonic.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val newsId: Int,
    val newsType: String,
    val title: String,
    val date: String,
    val imageUrl: String,
    val text: String,
)