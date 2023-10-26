package com.hugidonic.data.converters

import com.hugidonic.data.database.entities.SubjectEntity
import com.hugidonic.data.remote.dto.SubjectDto
import com.hugidonic.domain.models.SubjectModel

fun SubjectDto.toSubjectEntity(scheduleDayId: String): SubjectEntity = SubjectEntity(
    subjectTitle = title,
    type = type,
    prepod = prepod,
    shortTitle = shortTitle,
    cabinet = cabinet,
    duration = duration,
    startTime = startTime,
    endTime = endTime,
    scheduleDayId = scheduleDayId
)

fun SubjectEntity.toSubjectModel(): SubjectModel = SubjectModel(
    title = subjectTitle,
    type = type,
    prepod = prepod,
    shortTitle = shortTitle,
    cabinet = cabinet,
    duration = duration,
    startTime = startTime,
    endTime = endTime,
    scheduleDayId = scheduleDayId,
    subjectId = subjectId ?: -1,
)

