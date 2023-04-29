package com.hugidonic.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("schedule_day")
data class ScheduleDayDbModel(
	@PrimaryKey
	val dayOfWeek: String,
	val typeOfWeek: String,
	val date: String,
	val subjects: String,
)