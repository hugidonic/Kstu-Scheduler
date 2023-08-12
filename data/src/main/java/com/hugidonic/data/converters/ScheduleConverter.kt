package com.hugidonic.data.converters

import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.remote.dto.ScheduleDayDto
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.utils.DayOfWeek

fun ScheduleDayDto.toScheduleDayEntity(): ScheduleDayEntity = ScheduleDayEntity(
    dayOfWeek = dayOfWeek,
    typeOfWeek = typeOfWeek,
    date = date,
)

fun ScheduleDayModel.toScheduleDayEntity(): ScheduleDayEntity = ScheduleDayEntity(
    dayOfWeek = dayOfWeek,
    typeOfWeek = typeOfWeek,
    date = date,
)

fun ScheduleDayEntity.toScheduleDayModel(): ScheduleDayModel = ScheduleDayModel(
    dayOfWeek = dayOfWeek,
    typeOfWeek = typeOfWeek,
    date = date,
)
