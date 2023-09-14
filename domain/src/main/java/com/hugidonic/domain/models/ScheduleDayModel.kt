package com.hugidonic.domain.models

data class ScheduleDayModel(
    val scheduleDayId: String,
    val dayOfWeek: String,
    val typeOfWeek: String,
    val date: String,
    val subjects: List<SubjectModel>
)