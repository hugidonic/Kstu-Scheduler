package com.hugidonic.data.converters

import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.utils.DayOfWeek

fun ScheduleDayModel.toScheduleDayEntity(): ScheduleDayEntity = ScheduleDayEntity (
	dayOfWeek = DayOfWeek.valueOf(dayOfWeek),
	typeOfWeek = typeOfWeek,
	date = date,
)

fun ScheduleDayEntity.toScheduleDayModel(): ScheduleDayModel = ScheduleDayModel(
	dayOfWeek = dayOfWeek.toString(),
	typeOfWeek = typeOfWeek,
	date = date,
	subjects = emptyList()
)
