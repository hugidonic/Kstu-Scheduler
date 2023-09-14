package com.hugidonic.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_day")
data class ScheduleDayEntity(
    @PrimaryKey(autoGenerate = false)
    val scheduleDayId: String,

    val dayOfWeek: String,
    val typeOfWeek: String,
    val date: String,
)
