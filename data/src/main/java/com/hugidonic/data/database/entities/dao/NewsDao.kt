package com.hugidonic.data.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hugidonic.data.database.entities.NewsEntity

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(newsEntity: NewsEntity)

    @Query("SELECT * FROM news WHERE newsType = :newsType")
    suspend fun getAllNewsByType(newsType: String): List<NewsEntity>

    @Query("SELECT * FROM news WHERE newsId = :newsId LIMIT 1")
    suspend fun getNewsById(newsId: Int): NewsEntity

    @Query("DELETE FROM news WHERE newsType = :newsType")
    suspend fun deleteNewsByType(newsType: String)

    @Query("DELETE FROM news")
    suspend fun clearNewsTable()
}