package com.hugidonic.data.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hugidonic.data.database.entities.ClassEntity
import com.hugidonic.data.database.entities.ScheduleDayEntity

data class ScheduleDayWithClasses(
    @Embedded val scheduleDay: ScheduleDayEntity,
    @Relation(
        parentColumn = "dayOfWeek",
        entityColumn = "classId"
    )
    val classes: List<ClassEntity>
)

