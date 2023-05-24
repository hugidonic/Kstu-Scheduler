package com.hugidonic.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugidonic.domain.utils.DayOfWeek

@Entity("schedule_day")
data class ScheduleDayEntity(
	@PrimaryKey(autoGenerate = false)
	val dayOfWeek: DayOfWeek,
	val typeOfWeek: String,
	val date: String,
)

