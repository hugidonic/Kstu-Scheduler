package com.hugidonic.data.converters

import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.database.entities.relations.ScheduleDayWithSubjects
import com.hugidonic.data.remote.dto.ScheduleDayDto
import com.hugidonic.domain.models.ScheduleDayModel

fun ScheduleDayDto.toScheduleDayEntity(): ScheduleDayEntity = ScheduleDayEntity(
    dayOfWeek = dayOfWeek,
    typeOfWeek = typeOfWeek,
    date = date,
    scheduleDayId = "${typeOfWeek}/${dayOfWeek}"
)

fun ScheduleDayEntity.toModel(): ScheduleDayModel = ScheduleDayModel(
    dayOfWeek = dayOfWeek,
    typeOfWeek = typeOfWeek,
    date = date,
    scheduleDayId = "${typeOfWeek}/${dayOfWeek}",
    subjects = emptyList(),
)

fun ScheduleDayWithSubjects.toModel(): ScheduleDayModel = ScheduleDayModel(
    dayOfWeek = scheduleDayInfo.dayOfWeek,
    typeOfWeek = scheduleDayInfo.typeOfWeek,
    date = scheduleDayInfo.date,
    scheduleDayId = "${scheduleDayInfo.typeOfWeek}/${scheduleDayInfo.dayOfWeek}",
    subjects = subjects.map { it.toSubjectModel() },
)

fun ScheduleDayModel.toScheduleDayEntity(): ScheduleDayEntity = ScheduleDayEntity(
    dayOfWeek = dayOfWeek,
    typeOfWeek = typeOfWeek,
    date = date,
    scheduleDayId = scheduleDayId
)
