package com.hugidonic.data.database.entities

import androidx.room.Entity

@Entity(
    tableName = "subject",
    primaryKeys = ["subjectTitle"]
)
data class SubjectEntity(
    val subjectTitle: String,
    val typeOfSubject: String,
    val prepod: String,
    val shortTitle: String,
    val cabinet: String,
    val date: String,
)