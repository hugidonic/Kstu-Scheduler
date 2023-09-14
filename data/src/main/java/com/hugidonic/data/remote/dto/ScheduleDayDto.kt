package com.hugidonic.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ScheduleDayDto(
    @SerializedName("date")
    val date: String,

    @SerializedName("dayOfWeek")
    val dayOfWeek: String,

    @SerializedName("subjects")
    val subjects: List<SubjectDto>,

    @SerializedName("typeOfWeek")
    val typeOfWeek: String
)