package com.hugidonic.data.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.database.entities.SubjectEntity

data class ScheduleDayWithSubjects(
    @Embedded val scheduleDayInfo: ScheduleDayEntity,
    @Relation(
        parentColumn = "scheduleDayId",
        entityColumn = "scheduleDayId",
        entity = SubjectEntity::class,
    )
    val subjects: List<SubjectEntity>,
)
