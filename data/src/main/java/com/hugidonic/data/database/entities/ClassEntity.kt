package com.hugidonic.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("class_subject")
data class ClassEntity(
    @PrimaryKey(autoGenerate = true)
    val classId: Int? = null,
    val subjectTitle: String,
    val dayOfWeek: String,
    val orderIndex: Int,
)
