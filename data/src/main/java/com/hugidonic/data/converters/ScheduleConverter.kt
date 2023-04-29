package com.hugidonic.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hugidonic.data.database.models.ScheduleDayDbModel
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import java.lang.Exception

class ScheduleConverter {
	@TypeConverter
	fun scheduleDbModelToModel(scheduleDayDbModel: ScheduleDayDbModel): ScheduleDayModel = ScheduleDayModel(
		dayOfWeek = scheduleDayDbModel.dayOfWeek,
		typeOfWeek = scheduleDayDbModel.typeOfWeek,
		date = scheduleDayDbModel.date,
		subjects = convertStringSubjectsToList(scheduleDayDbModel.subjects)
	)

	@TypeConverter
	fun scheduleModelToDbModel(
		scheduleDayModel: ScheduleDayModel
	): ScheduleDayDbModel = ScheduleDayDbModel (
		dayOfWeek = scheduleDayModel.dayOfWeek,
		typeOfWeek = scheduleDayModel.typeOfWeek,
		date = scheduleDayModel.date,
		subjects = convertSubjectListToString(scheduleDayModel.subjects)
	)

	@TypeConverter
	fun convertSubjectListToString(subjects: List<SubjectModel?>): String {
		return Gson().toJson(subjects)
	}

	@TypeConverter
	fun convertStringSubjectsToList(subjectsJson: String): List<SubjectModel> {
		return try {
			Gson().fromJson(subjectsJson, SubjectsListType)
		} catch (e: Exception) {
			arrayListOf()
		}
	}

	companion object {
		val SubjectsListType = object : TypeToken<List<SubjectModel>>() {}.type
	}
}