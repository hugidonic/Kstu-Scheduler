package com.hugidonic.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugidonic.domain.utils.DayOfWeek

@Entity("class_subject")
data class ClassEntity(
    @PrimaryKey(autoGenerate = true)
    val classId: Int? = null,
    val subjectTitle: String,

    val dayOfWeek: DayOfWeek,
    val orderIndex: Int,

)
