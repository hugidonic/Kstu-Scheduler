package com.hugidonic.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugidonic.domain.models.SubjectModel

@Entity("schedule_day")
data class ScheduleDayDbModel(
	@PrimaryKey
	val dayOfWeek: String,
	val typeOfWeek: String,
	val date: String,
	val subjects: List<SubjectModel?>,
)