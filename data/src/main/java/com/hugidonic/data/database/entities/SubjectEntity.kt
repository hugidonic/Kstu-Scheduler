package com.hugidonic.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject")
data class SubjectEntity(
    @PrimaryKey(autoGenerate = false)
    val subjectTitle: String,
    val scheduleDayId: String,

    val type: String,
    val prepod: String,
    val shortTitle: String,
    val cabinet: String,
    val duration: String,
    val startTime: String,
    val endTime: String
)