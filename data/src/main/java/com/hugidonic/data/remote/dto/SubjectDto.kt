package com.hugidonic.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SubjectDto(
    @SerializedName("cabinet")
    val cabinet: String,

    @SerializedName("duration")
    val duration: String,

    @SerializedName("endTime")
    val endTime: String,

    @SerializedName("prepod")
    val prepod: String,

    @SerializedName("shortTitle")
    val shortTitle: String,

    @SerializedName("startTime")
    val startTime: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("type")
    val type: String
)