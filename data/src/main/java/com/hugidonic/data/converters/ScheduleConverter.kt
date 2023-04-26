package com.hugidonic.data.converters

import com.hugidonic.data.database.ScheduleDayDbModel
import com.hugidonic.domain.models.ScheduleDayModel

class ScheduleConverter {
	fun scheduleDbModelToModel(scheduleDayDbModel: ScheduleDayDbModel): ScheduleDayModel = ScheduleDayModel(
		dayOfWeek = scheduleDayDbModel.dayOfWeek,
		typeOfWeek = scheduleDayDbModel.typeOfWeek,
		date = scheduleDayDbModel.date,
		subjects = scheduleDayDbModel.subjects,
	)

	fun scheduleModelToDbModel(
		scheduleDayModel: ScheduleDayModel
	): ScheduleDayDbModel = ScheduleDayDbModel (
		dayOfWeek = scheduleDayModel.dayOfWeek,
		typeOfWeek = scheduleDayModel.typeOfWeek,
		date = scheduleDayModel.date,
		subjects = scheduleDayModel.subjects,
	)
}