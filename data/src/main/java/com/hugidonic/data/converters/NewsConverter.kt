package com.hugidonic.data.converters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hugidonic.data.database.entities.NewsEntity
import com.hugidonic.data.remote.dto.NewsDto
import com.hugidonic.domain.models.NewsModel

fun restoreList(listOfString: String?): List<String> {
    return Gson().fromJson(listOfString, object : TypeToken<List<String?>?>() {}.type)
}

fun saveList(listOfString: List<String?>?): String {
    return Gson().toJson(listOfString)
}

fun NewsEntity.toModel(): NewsModel = NewsModel(
    title = title,
    date = date,
    imageUrl = restoreList(imageUrl),
    text = text,
    newsType = newsType,
    newsId = newsId
)

fun NewsDto.toEntity(newsType: String): NewsEntity = NewsEntity(
    newsId = newsId,
    title = title,
    date = date,
    imageUrl = saveList(imageUrl),
    text = text,
    newsType = newsType,
)