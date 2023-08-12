package com.hugidonic.data.remote.dto

data class ScheduleDayDto(
    val dayOfWeek: String,
    val typeOfWeek: String,
    val date: String,
    val subjects: List<SubjectDto?>,
)