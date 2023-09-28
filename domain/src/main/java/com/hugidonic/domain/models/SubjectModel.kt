package com.hugidonic.domain.models

data class SubjectModel(
	val scheduleDayId: String,
	val title: String,
	val shortTitle: String,
	val type: String,
	val cabinet: String,
	val duration: String,
	val prepod: String,
	val startTime: String,
	val endTime: String,
)