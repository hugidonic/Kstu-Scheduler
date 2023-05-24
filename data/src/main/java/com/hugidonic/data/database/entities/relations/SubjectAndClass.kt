package com.hugidonic.data.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hugidonic.data.database.entities.ClassEntity
import com.hugidonic.data.database.entities.SubjectEntity

data class SubjectAndClass(
    @Embedded val classEntity: ClassEntity,
    @Relation(
        parentColumn = "subjectTitle",
        entityColumn = "subjectTitle",
    )
    val subject: SubjectEntity,
)
